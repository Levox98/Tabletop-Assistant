package com.tabletop_assistant.core_domain.usecase.character

import com.tabletop_assistant.core_domain.Either
import com.tabletop_assistant.core_domain.entity.Race
import com.tabletop_assistant.core_domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterRacesFlowUseCase (
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<Either<List<Race>>> = repository.loadRaces()
}