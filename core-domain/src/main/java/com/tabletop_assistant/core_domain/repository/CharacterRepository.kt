package com.tabletop_assistant.core_domain.repository

import com.tabletop_assistant.core_domain.Either
import com.tabletop_assistant.core_domain.entity.Race

interface CharacterRepository {

	fun createCharacter()
	fun getCharacter()
	fun updateCharacter()
	fun deleteCharacter()

	suspend fun loadRaces(): Either<List<String>>
	suspend fun loadRaceInfo(raceIndex: String): Either<Race>
	suspend fun loadClasses(): Either<List<String>>
}