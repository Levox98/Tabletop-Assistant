package com.tabletop_assistant.core_data.net.service

import com.tabletop_assistant.core_data.net.response.CharacterClassListResponse
import com.tabletop_assistant.core_data.net.response.RaceListResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {

	@GET("races")
	suspend fun getRacesList(): Response<RaceListResponse>

	@GET("classes")
	suspend fun getClassesList(): Response<CharacterClassListResponse>
}