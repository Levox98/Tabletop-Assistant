package com.tabletop_assistant.core_data.net

import retrofit2.Response

open class BaseApi {

	// TODO: implement error checking via some "Result" wrapper
	suspend fun <T, R> runRequest(
		request: suspend () -> Response<T>,
		mapper: (T) -> R
	): R? {
		val result = request()

		val res = if (result.isSuccessful) {
			result.body()?.let { mapper(it) }
		} else {
			null
		}

		return res
	}
}