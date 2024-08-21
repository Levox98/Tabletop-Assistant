package com.tabletop_assistant.domain.repository

import com.tabletop_assistant.domain.entity.Dice

interface RandomizeRepository {

	fun rollDice(dice: Dice): Int
	fun rollMultipleDice(diceList: List<Dice>): Int
}