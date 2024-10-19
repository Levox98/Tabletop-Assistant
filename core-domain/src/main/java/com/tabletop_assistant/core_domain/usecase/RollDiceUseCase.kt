package com.tabletop_assistant.core_domain.usecase

import com.tabletop_assistant.core_domain.entity.Dice
import com.tabletop_assistant.core_domain.repository.RandomRepository

class RollDiceUseCase(private val repository: RandomRepository) {
	operator fun invoke(vararg dice: Dice) = repository.rollDice(*dice)
}