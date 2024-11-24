package com.tabletop_assistant.feature_character.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tabletop_assistant.core_domain.Either
import com.tabletop_assistant.core_domain.usecase.character.LoadCharacterClassIndicesUseCase
import com.tabletop_assistant.core_domain.usecase.character.LoadCharacterRacesUseCase
import com.tabletop_assistant.core_domain.usecase.character.LoadRaceInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CharacterViewModelState(
    var isLoading: Boolean,
    var error: Throwable?,
    var indexList: List<String>? = null
)

sealed interface CharacterViewModelIntent {
    data object LoadClasses : CharacterViewModelIntent
}

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val loadCharacterRacesUseCase: LoadCharacterRacesUseCase,
    private val loadRaceInfoUseCase: LoadRaceInfoUseCase,
    private val loadCharacterClassIndicesUseCase: LoadCharacterClassIndicesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterViewModelState(false, null))
    val state: StateFlow<CharacterViewModelState> = _state.asStateFlow()

    private val _characterClassIndices = MutableStateFlow<List<String>>(emptyList())
    val characterClassIndices: StateFlow<List<String>> = _characterClassIndices.asStateFlow()

    fun collectIntent(intent: CharacterViewModelIntent) {
        when (intent) {
            CharacterViewModelIntent.LoadClasses -> loadCharacterClassIndices()
        }
    }

    private fun loadCharacterClassIndices() {
        viewModelScope.launch {
            when (val result = loadCharacterClassIndicesUseCase()) {
                is Either.Loading -> {
                    _state.value = _state.value.copy(isLoading = true, error = null)
                }
                is Either.Success -> {
                    _state.value = _state.value.copy(isLoading = false, error = null, indexList = result.data)
                }
                is Either.Error -> {
                    _state.value = _state.value.copy(isLoading = false, error = result.error)
                }
            }
        }
    }
}