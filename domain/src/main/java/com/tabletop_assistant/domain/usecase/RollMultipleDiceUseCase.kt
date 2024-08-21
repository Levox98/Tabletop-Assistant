package com.tabletop_assistant.domain.usecase

import com.tabletop_assistant.domain.entity.Dice
import com.tabletop_assistant.domain.repository.RandomizeRepository
import javax.inject.Inject

class RollMultipleDiceUseCase @Inject constructor(
	private val repository: RandomizeRepository
) {
	operator fun invoke(diceList: List<Dice>) = repository.rollMultipleDice(diceList)
}