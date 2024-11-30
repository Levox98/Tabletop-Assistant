package com.tabletop_assistant.core_domain.repository

import com.tabletop_assistant.core_domain.Either
import com.tabletop_assistant.core_domain.entity.Race
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

	fun createCharacter()
	fun getCharacter()
	fun updateCharacter()
	fun deleteCharacter()

	fun loadRaces(): Flow<Either<List<Race>>>
	suspend fun loadRaceInfo(raceIndex: String): Either<Race>
	suspend fun loadClasses(): Either<List<String>>
}