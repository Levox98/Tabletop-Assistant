package com.tabletop_assistant.core_data.net.api

import com.tabletop_assistant.core.Either
import com.tabletop_assistant.core_data.entity.CharacterClassDataEntity
import com.tabletop_assistant.core_data.entity.RaceDataEntity
import com.tabletop_assistant.core_data.net.BaseApi
import com.tabletop_assistant.core_data.net.service.CharacterService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterApi @Inject constructor(
	private val service: CharacterService
) : BaseApi() {

	suspend fun loadRaces(): Either<List<RaceDataEntity>?> =
		runRequest(
			tag = "loadRaces",
			request = {
				service.getRacesList()
			},
			mapper = {
				it.results.map { raceEntity ->
					RaceDataEntity(raceEntity.index, raceEntity.name, raceEntity.url)
				}
			}
		)

	suspend fun loadCharacterClasses(): Either<List<CharacterClassDataEntity>?> =
		runRequest(
			tag = "loadCharacterClasses",
			request = {
				service.getClassesList()
			},
			mapper = {
				it.results.map { characterClassEntity ->
					CharacterClassDataEntity(
						characterClassEntity.index,
						characterClassEntity.name,
						characterClassEntity.url
					)
				}
			}
		)
}