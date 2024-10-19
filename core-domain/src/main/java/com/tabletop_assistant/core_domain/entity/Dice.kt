package com.tabletop_assistant.core_domain.entity

data class Dice(val sides: Int) {

	companion object {
		val dice4 = Dice(4)
		val dice6 = Dice(6)
		val dice8 = Dice(8)
		val dice10 = Dice(10)
		val dice12 = Dice(12)
		val dice20 = Dice(20)
	}
}
