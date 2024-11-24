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
		val url: String,
		@SerializedName("speed")
		val speed: Int,
		@SerializedName("ability_bonuses")
		val abilityBonuses: List<AbilityBonusEntity>,
		@SerializedName("alignment")
		val alignment: String,
		@SerializedName("age")
		val age: String,
		@SerializedName("size")
		val size: String,
		@SerializedName("size_description")
		val sizeDescription: String,
		@SerializedName("starting_proficiencies")
		val startingProficiencies: List<String>, // TODO
		@SerializedName("languages")
		val languages: List<LanguageEntity>,
		@SerializedName("language_desc")
		val languageDesc: String,
		@SerializedName("traits")
		val traits: List<TraitEntity>,
		@SerializedName("subraces")
		val subraces: List<String> // TODO
	) {

		data class AbilityBonusEntity(
			@SerializedName("ability_score")
			val abilityScore: AbilityScoreEntity,
			@SerializedName("bonus")
			val bonus: Int
		) {

			data class AbilityScoreEntity(
				@SerializedName("index")
				val index: String,
				@SerializedName("name")
				val name: String,
				@SerializedName("url")
				val url: String
			)
		}

		data class LanguageEntity(
			@SerializedName("index")
			val index: String,
			@SerializedName("name")
			val name: String,
			@SerializedName("url")
			val url: String
		)

		data class TraitEntity(
			@SerializedName("index")
			val index: String,
			@SerializedName("name")
			val name: String,
			@SerializedName("url")
			val url: String
		)
	}
}