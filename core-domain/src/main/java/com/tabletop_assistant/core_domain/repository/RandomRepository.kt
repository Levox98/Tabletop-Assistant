package com.tabletop_assistant.core_domain.repository

import com.tabletop_assistant.core_domain.entity.Dice
import com.tabletop_assistant.core_domain.entity.Roll

interface RandomRepository {

	fun rollDice(vararg dice: Dice): Pair<Int, Int>
	fun saveCustomRoll(vararg dice: Dice)
	fun getCustomRolls(): List<Roll>
}