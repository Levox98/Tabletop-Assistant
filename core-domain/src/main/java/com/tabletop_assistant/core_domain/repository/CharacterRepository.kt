package com.tabletop_assistant.core_domain.repository

import com.tabletop_assistant.core_domain.Either

interface CharacterRepository {

	fun createCharacter()
	fun getCharacter()
	fun updateCharacter()
	fun deleteCharacter()

	suspend fun loadClassIndices(): Either<List<String>>
}