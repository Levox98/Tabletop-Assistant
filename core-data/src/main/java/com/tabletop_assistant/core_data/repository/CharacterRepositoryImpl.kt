package com.tabletop_assistant.core_data.repository

import com.tabletop_assistant.core_data.mappers.toDomain
import com.tabletop_assistant.core_data.net.api.CharacterApi
import com.tabletop_assistant.core_domain.Either
import com.tabletop_assistant.core_domain.entity.Race
import com.tabletop_assistant.core_domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
	private val characterApi: CharacterApi
) : CharacterRepository {

	override fun createCharacter() {
		TODO("Not yet implemented")
	}

	override fun getCharacter() {
		TODO("Not yet implemented")
	}

	override fun updateCharacter() {
		TODO("Not yet implemented")
	}

	override fun deleteCharacter() {
		TODO("Not yet implemented")
	}

	override fun loadRaces(): Flow<Either<List<Race>>> = flow {

		emit(Either.Loading)

		when (val result = characterApi.loadRaces()) {
			is Either.Error -> emit(Either.Error(result.error))
			is Either.Success -> emit(Either.Success(result.data?.map { it.toDomain() }))
			else -> emit(Either.Error(UnknownError("unknown error in method: loadRaces()")))
		}
	}

	override fun loadRaceInfo(raceIndex: String): Flow<Either<Race>> = flow {

		emit(Either.Loading)

		when (val result = characterApi.loadRaceInfo(raceIndex)) {
			is Either.Error -> emit(Either.Error(result.error))
			is Either.Success -> emit(Either.Success(result.data?.toDomain()))
			else -> emit(Either.Error(UnknownError("unknown error in method: loadRaceInfo")))
		}
	}

	override fun loadClasses(): Flow<Either<List<String>>> = flow {

		emit(Either.Loading)

		when (val result = characterApi.loadCharacterClasses()) {
			is Either.Error -> emit(Either.Error(result.error))
			is Either.Success -> emit(Either.Success(result.data?.map { it.index }))
			else -> emit(Either.Error(UnknownError("unknown error in method: loadClasses")))
		}
	}
}