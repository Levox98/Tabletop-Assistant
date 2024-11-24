package com.tabletop_assistant.core_data.net.service

import com.tabletop_assistant.core_data.net.response.CharacterClassListResponse
import com.tabletop_assistant.core_data.net.response.RaceListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

	@GET("races")
	suspend fun getRacesList(): Response<RaceListResponse>

	@GET("races/{index}")
	suspend fun getRaceInfo(
		@Path(value = "index", encoded = true) raceIndex: String
	): Response<RaceListResponse.RaceEntity>

	@GET("classes")
	suspend fun getClassesList(): Response<CharacterClassListResponse>
}