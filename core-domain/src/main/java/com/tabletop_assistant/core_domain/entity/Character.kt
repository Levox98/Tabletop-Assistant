package com.tabletop_assistant.core_domain.entity

data class Character(
	val race: String,
	val charClass: String,
	val background: String,
//	val name: String,
//	val level: Int,
//	val abilityStats: List<Int>, // ability scores should include modifiers
//	val skills: List<String>, // skills are basically modifiers
//	val proficiency: Int, // +2
//	val savingThrows: List<String>, // 2 saving throws
//	val inventory: List<String>, // items
//	val wisdom: Int, // passive from perception
)
