package com.tabletop_assistant.core_data.repository

import com.tabletop_assistant.core_domain.entity.Dice
import com.tabletop_assistant.core_domain.repository.RandomRepository
import kotlin.random.Random

class RandomRepositoryImpl : RandomRepository {

	override fun rollDice(vararg dice: Dice): Pair<Int, Int> {
		var rollResult = 0
		val maxResult: Int = dice.sumOf { it.sides }

		for (item in dice) {
			rollResult += Random.nextInt(item.sides) + 1
		}

		return Pair(rollResult, maxResult)
	}
}