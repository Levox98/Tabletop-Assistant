package com.tabletop_assistant.core_common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel<T: BaseViewModelState>(initialState: T) : ViewModel() {

    private var cachedState: T? = null

    private val _state = MutableStateFlow<T>(initialState)
    val state: StateFlow<T>
        get() = _state.asStateFlow()

    fun updateState(newState: T) {
        _state.value = newState
    }
}