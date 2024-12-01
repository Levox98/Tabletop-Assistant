package com.tabletop_assistant.core_domain.usecase.character

import com.tabletop_assistant.core_domain.repository.CharacterRepository

class LoadCharacterClassIndicesFlowUseCase(
    private val repository: CharacterRepository
) {
    operator fun invoke() = repository.loadClasses()
}