package com.tabletop_assistant.core

sealed class Either<T> {

	data object Loading : Either<Nothing>()

	data class Success<T>(val data: T?) : Either<T>()

	data class Error<T>(val error: Throwable) : Either<T>()
}