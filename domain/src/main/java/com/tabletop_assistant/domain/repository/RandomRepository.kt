package com.tabletop_assistant.domain.repository

import com.tabletop_assistant.domain.entity.Dice

interface RandomRepository {

	fun rollDice(dice: Dice): Int
}