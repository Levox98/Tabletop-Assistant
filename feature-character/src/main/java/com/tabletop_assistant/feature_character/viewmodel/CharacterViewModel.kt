package com.tabletop_assistant.feature_character.viewmodel

import androidx.lifecycle.viewModelScope
import com.tabletop_assistant.core_common.BaseViewModel
import com.tabletop_assistant.core_common.BaseViewModelState
import com.tabletop_assistant.core_domain.Either
import com.tabletop_assistant.core_domain.entity.Race
import com.tabletop_assistant.core_domain.usecase.character.GetCharacterRacesFlowUseCase
import com.tabletop_assistant.core_domain.usecase.character.LoadCharacterClassIndicesUseCase
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
    data class Content(val raceList: List<Race>) : CharacterScreenDisplayState
}

sealed interface CharacterViewModelIntent {
    data object LoadClasses : CharacterViewModelIntent
}

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterRacesFlowUseCase: GetCharacterRacesFlowUseCase,
    private val loadRaceInfoUseCase: LoadRaceInfoUseCase,
    private val loadCharacterClassIndicesUseCase: LoadCharacterClassIndicesUseCase
) : BaseViewModel<CharacterScreenState>(CharacterScreenState()) {

    fun collectIntent(intent: CharacterViewModelIntent) {
        when (intent) {
            CharacterViewModelIntent.LoadClasses -> getCharacterRacesFlow()
        }
    }

    private fun getCharacterRacesFlow() {
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

                        is Either.Success -> updateState(
                            state.value.copy(
                                isLoading = false,
                                error = null,
                                displayState = CharacterScreenDisplayState.Content(
                                    res.data ?: emptyList()
                                )
                            )
                        )
                    }
                }
            }
        }
    }
}