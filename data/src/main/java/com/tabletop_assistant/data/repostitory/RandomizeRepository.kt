package com.tabletop_assistant.data.repostitory

import com.tabletop_assistant.domain.entity.Dice
import com.tabletop_assistant.domain.repository.RandomizeRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class RandomizeRepositoryImpl @Inject constructor() : RandomizeRepository {

	override fun rollDice(dice: Dice): Int {
		return Random.nextInt(1, dice.sides)
	}

	override fun rollMultipleDice(diceList: List<Dice>): Int {
		return diceList.sumOf { Random.nextInt(1, it.sides) }
	}
}