package com.tabletop_assistant.core_data.net.response

import com.google.gson.annotations.SerializedName

class CharacterClassListResponse(
	@SerializedName("count")
	override val count: Int,
	@SerializedName("results")
	val results: List<CharacterClassEntity>
) : BaseListResponse {

	data class CharacterClassEntity(
		@SerializedName("index")
		val index: String,
		@SerializedName("name")
		val name: String,
		@SerializedName("url")
		val url: String
	)
}