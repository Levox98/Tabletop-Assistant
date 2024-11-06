package com.tabletop_assistant.core_data.net

import com.tabletop_assistant.core.Either
import retrofit2.Response

open class BaseApi {

	suspend fun <T, R> runRequest(
		tag: String,
		request: suspend () -> Response<T>,
		mapper: (T) -> R
	): Either<R?> {
		println("Running request: $tag")

		val result = request()

		val res = if (result.isSuccessful) {
			result.body()?.let { mapper(it) }
		} else {
			return Either.Error(Exception("Request failed: $tag"))
		}

		return Either.Success(res)
	}
}