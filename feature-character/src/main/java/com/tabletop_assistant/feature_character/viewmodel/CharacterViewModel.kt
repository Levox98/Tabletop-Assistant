package com.tabletop_assistant.feature_character.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tabletop_assistant.core_domain.Either
import com.tabletop_assistant.core_domain.usecase.character.LoadCharacterClassIndicesUseCase
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

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val loadCharacterClassIndicesUseCase: LoadCharacterClassIndicesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterViewModelState(false, null))
    val state: StateFlow<CharacterViewModelState> = _state.asStateFlow()

    private val _characterClassIndices = MutableStateFlow<List<String>>(emptyList())
    val characterClassIndices: StateFlow<List<String>> = _characterClassIndices.asStateFlow()

    init {
        loadCharacterClassIndices()
    }

    private fun loadCharacterClassIndices() {
        viewModelScope.launch {
            when (val result = loadCharacterClassIndicesUseCase()) {
                is Either.Loading -> {
                    _state.value = _state.value.copy(isLoading = true, error = null)
                    println("newState loading: ${_state.value}")
                }
                is Either.Success -> {
                    _state.value = _state.value.copy(isLoading = false, error = null, indexList = result.data)
                    println("newState success: ${_state.value}")
                }
                is Either.Error -> {
                    _state.value = _state.value.copy(isLoading = false, error = result.error)
                    println("newState error: ${_state.value}")
                }
            }
        }
    }
}