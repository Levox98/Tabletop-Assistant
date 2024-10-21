package com.tabletop_assistant.core_domain.entity

data class Character(
	val name: String,
	val level: Int,
	val race: String,
	val classValue: String,
	val abilityStats: List<Int>, // ability scores should include modifiers
	val skills: List<String>, // skills are basically modifiers
	val background: String,
	val proficiency: Int, // +2
	val savingThrows: List<String>, // 2 saving throws
	val inventory: List<String>, // items
	val wisdom: Int, // passive from perception
)
