package com.tabletop_assistant.core_domain.repository

interface CharacterRepository {

	fun createCharacter()
	fun getCharacter()
	fun updateCharacter()
	fun deleteCharacter()

}