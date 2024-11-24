package com.tabletop_assistant.core_data.entity

data class RaceDataEntity(
	val index: String,
	val name: String,
	val url: String,
	val speed: Int,
	val abilityBonuses: List<AbilityBonusDataEntity>,
	val alignment: String,
	val age: String,
	val size: String,
	val sizeDescription: String,
	val startingProficiencies: List<String>, // TODO
	val languages: List<LanguageDataEntity>,
	val languageDesc: String,
	val traits: List<TraitDataEntity>,
	val subraces: List<String> // TODO
) {

	data class AbilityBonusDataEntity(
		val abilityScore: AbilityScoreDataEntity,
		val bonus: Int
	) {

		data class AbilityScoreDataEntity(
			val index: String,
			val name: String,
			val url: String
		)
	}

	data class LanguageDataEntity(
		val index: String,
		val name: String,
		val url: String
	)

	data class TraitDataEntity(
		val index: String,
		val name: String,
		val url: String
	)
}
