package com.tabletop_assistant.core_common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

open class BaseViewModel<T : BaseViewModelState>(initialState: T) : ViewModel() {

    private var cachedState: T? = null

    private val _state = MutableStateFlow<T>(initialState)
    val state: StateFlow<T>
        get() {
            Timber.tag("${LOG_TAG}_getState")
                .v("getting state of type ${_state.value.javaClass.canonicalName}: ${_state.value}")
            return _state.asStateFlow()
        }

    fun updateState(newState: T) {
        Timber.tag("${LOG_TAG}_updateState")
            .v("${_state.value.javaClass.canonicalName} newState: $newState")
        _state.value = newState
    }

    companion object {
        private const val LOG_TAG = "log_vm"
    }
}