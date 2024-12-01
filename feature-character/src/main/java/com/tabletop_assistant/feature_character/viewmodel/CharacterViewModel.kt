package com.tabletop_assistant.feature_character.viewmodel

import androidx.lifecycle.viewModelScope
import com.tabletop_assistant.core_common.BaseViewModel
import com.tabletop_assistant.core_common.BaseViewModelState
import com.tabletop_assistant.core_domain.Either
import com.tabletop_assistant.core_domain.entity.Race
import com.tabletop_assistant.core_domain.usecase.character.GetCharacterRacesFlowUseCase
import com.tabletop_assistant.core_domain.usecase.character.LoadCharacterClassIndicesFlowUseCase
import com.tabletop_assistant.core_domain.usecase.character.LoadRaceInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


data class CharacterScreenState(
    override var isLoading: Boolean = false,
    override var error: Throwable? = null,
    val displayState: CharacterScreenDisplayState = CharacterScreenDisplayState.Default
) : BaseViewModelState

sealed interface CharacterScreenDisplayState {
    data object Default : CharacterScreenDisplayState
    data object Loading : CharacterScreenDisplayState
    data class Error(val error: Throwable) : CharacterScreenDisplayState
    data class Content(
        val raceList: List<Race> = emptyList(),
        val raceInfo: Race? = null,
        val classList: List<String> = emptyList()
    ) : CharacterScreenDisplayState
}

sealed interface CharacterViewModelIntent {
    data object LoadRaces : CharacterViewModelIntent
    data class LoadRaceInfo(val raceIndex: String) : CharacterViewModelIntent
    data object LoadClasses : CharacterViewModelIntent
}

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterRacesFlowUseCase: GetCharacterRacesFlowUseCase,
    private val loadRaceInfoUseCase: LoadRaceInfoUseCase,
    private val loadCharacterClassIndicesFlowUseCase: LoadCharacterClassIndicesFlowUseCase
) : BaseViewModel<CharacterScreenState>(CharacterScreenState()) {

    fun collectIntent(intent: CharacterViewModelIntent) {
        when (intent) {
            CharacterViewModelIntent.LoadRaces -> loadRaces()
            is CharacterViewModelIntent.LoadRaceInfo -> loadRaceInfo(intent.raceIndex)
            CharacterViewModelIntent.LoadClasses -> loadClasses()
        }
    }

    private fun loadRaces() {
        viewModelScope.launch(Dispatchers.IO) {
            getCharacterRacesFlowUseCase().collect { res ->
                withContext(Dispatchers.Main) {
                    when (res) {
                        is Either.Error -> updateState(
                            state.value.copy(
                                isLoading = false,
                                error = res.error,
                                displayState = CharacterScreenDisplayState.Error(res.error)
                            )
                        )

                        Either.Loading -> updateState(
                            state.value.copy(
                                isLoading = true,
                                error = null,
                                displayState = CharacterScreenDisplayState.Loading
                            )
                        )

                        is Either.Success -> updateContent { oldContent ->
                            oldContent.copy(raceList = res.data ?: emptyList())
                        }
                    }
                }
            }
        }
    }

    private fun loadRaceInfo(raceIndex: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loadRaceInfoUseCase(raceIndex).collect { res ->
                withContext(Dispatchers.Main) {
                    when (res) {
                        is Either.Error -> updateState { old ->
                            old.copy(isLoading = false, error = res.error)
                        }

                        Either.Loading -> updateState { old ->
                            old.copy(isLoading = true, error = null)
                        }

                        is Either.Success -> updateContent { old ->
                            old.copy(raceInfo = res.data)
                        }
                    }
                }
            }
        }
    }

    private fun loadClasses() {
        viewModelScope.launch(Dispatchers.IO) {
            loadCharacterClassIndicesFlowUseCase().collect { res ->
                withContext(Dispatchers.Main) {
                    when (res) {
                        is Either.Error -> updateState(
                            state.value.copy(
                                isLoading = false,
                                error = res.error
                            )
                        )

                        Either.Loading -> updateState(
                            state.value.copy(
                                isLoading = true,
                                error = null
                            )
                        )

                        is Either.Success -> updateContent { old ->
                            old.copy(classList = res.data ?: emptyList())
                        }
                    }
                }
            }
        }
    }

    private inline fun updateContent(crossinline onContent: (CharacterScreenDisplayState.Content) -> CharacterScreenDisplayState.Content) {
        val currentContent = if (state.value.displayState is CharacterScreenDisplayState.Content)
            state.value.displayState as CharacterScreenDisplayState.Content
        else
            CharacterScreenDisplayState.Content()

        val newContent = onContent(currentContent)

        updateState(state.value.copy(displayState = newContent))
    }
}