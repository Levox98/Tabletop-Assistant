package com.tabletop_assistant.core_common

interface BaseViewModelState {
    var isLoading: Boolean
    var error: Throwable?
}