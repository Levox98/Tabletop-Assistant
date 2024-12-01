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
	fun loadRaceInfo(raceIndex: String): Flow<Either<Race>>
	fun loadClasses(): Flow<Either<List<String>>>
}