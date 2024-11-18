package com.tabletop_assistant.core_domain.usecase.character

import com.tabletop_assistant.core_domain.repository.CharacterRepository

class LoadCharacterClassIndicesUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke() = repository.loadClassIndices()
}