package com.tabletop_assistant.core_data.repository

import com.tabletop_assistant.core_data.AppCache
import com.tabletop_assistant.core_domain.entity.Dice
import com.tabletop_assistant.core_domain.repository.RandomRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class RandomRepositoryImpl @Inject constructor() : RandomRepository {

	override fun rollDice(vararg dice: Dice): Pair<Int, Int> {
		var rollResult = 0
		val maxResult: Int = dice.sumOf { it.sides }

		for (item in dice) {
			rollResult += Random.nextInt(item.sides) + 1
		}

		return Pair(rollResult, maxResult)
	}

	override fun saveCustomRoll(vararg dice: Dice) {
		// TODO: decide how to do this stuff
	}
}