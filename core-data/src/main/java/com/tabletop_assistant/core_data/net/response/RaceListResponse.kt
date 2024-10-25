package com.tabletop_assistant.core_data.net.response

import com.google.gson.annotations.SerializedName

class RaceListResponse(
	@SerializedName("count")
	override val count: Int,
	@SerializedName("results")
	val results: List<RaceEntity>
) : BaseListResponse {

	data class RaceEntity(
		@SerializedName("index")
		val index: String,
		@SerializedName("name")
		val name: String,
		@SerializedName("url")
		val url: String
	)
}