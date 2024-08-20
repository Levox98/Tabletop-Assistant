package com.tabletop_assistant.domain.usecase

import com.tabletop_assistant.domain.entity.Dice
import com.tabletop_assistant.domain.repository.RandomRepository
import javax.inject.Inject

class RollDiceUseCase @Inject constructor(
	private val repository: RandomRepository
) {
	operator fun invoke(dice: Dice) = repository.rollDice(dice)
}