package com.tabletop_assistant.core_domain

sealed class Either<out T> {

	fun isLoading(): Boolean {
		return this is Loading
	}

	fun isSuccess(): Boolean {
		return this is Success
	}

	fun isError(): Boolean {
		return this is Error
	}

	data object Loading : Either<Nothing>()

	data class Success<out T>(val data: T?) : Either<T>()

	data class Error<out T>(val error: Throwable) : Either<T>()
}