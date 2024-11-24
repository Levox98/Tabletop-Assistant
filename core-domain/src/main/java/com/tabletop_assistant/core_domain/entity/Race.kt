package com.tabletop_assistant.core_domain.entity

data class Race(
    val index: String,
    val name: String,
    val url: String,
    val speed: Int,
    val abilityBonuses: List<AbilityBonus>,
    val alignment: String,
    val age: String,
    val size: String,
    val sizeDescription: String,
    val startingProficiencies: List<String>, // TODO
    val languages: List<Language>,
    val languageDesc: String,
    val traits: List<Trait>,
    val subraces: List<String> // TODO
) {
    data class AbilityBonus(
        val abilityScore: AbilityScore,
        val bonus: Int
    ) {

        data class AbilityScore(
            val index: String,
            val name: String,
            val url: String
        )
    }

    data class Language(
        val index: String,
        val name: String,
        val url: String
    )

    data class Trait(
        val index: String,
        val name: String,
        val url: String
    )
}