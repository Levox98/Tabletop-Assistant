package com.tabletop_assistant.core_domain.entity

data class Roll(
	val title: String,
	val dice: List<Dice>,
) {
	// I wonder what the most optimal way of doing this would be...
	fun getStringRepresentation(): String {
		val sb = StringBuilder()

		val sidesToQuantityMap = dice.groupBy { it.sides }.toSortedMap()

		for (key in sidesToQuantityMap.keys) {
			sb.append("${sidesToQuantityMap[key]?.size}d$key")
			if (key < sidesToQuantityMap.lastKey()) sb.append('+')
		}

		return sb.toString()
	}
}