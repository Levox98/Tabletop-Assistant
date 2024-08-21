package com.tabletop_assistant.data.repostitory

import com.tabletop_assistant.domain.entity.Dice
import com.tabletop_assistant.domain.repository.RandomizeRepository
import kotlin.random.Random

class RandomizeRepositoryImpl : RandomizeRepository {

	override fun rollDice(dice: Dice): Int {
		return Random.nextInt(1, dice.sides)
	}

	override fun rollMultipleDice(diceList: List<Dice>): Int {
		return diceList.sumOf { Random.nextInt(1, it.sides) }
	}
}