package com.tabletop_assistant.data

import com.tabletop_assistant.data.repostitory.RandomizeRepositoryImpl
import com.tabletop_assistant.domain.entity.Dice
import org.junit.Test

class RandomizeRepoTest {

	private var repository = RandomizeRepositoryImpl()

	@Test
	fun singleDiceRollTest() {
		val testDice = Dice.entries.random()
		val roll = repository.rollDice(testDice)

		assert(roll in 1..testDice.sides)
	}

	@Test
	fun multipleDiceRollTest() {
		val testDiceList = listOf(Dice.entries.random(), Dice.entries.random(), Dice.entries.random())
		val roll = repository.rollMultipleDice(testDiceList)

		assert(roll in testDiceList.size..testDiceList.sumOf { it.sides })
	}
}