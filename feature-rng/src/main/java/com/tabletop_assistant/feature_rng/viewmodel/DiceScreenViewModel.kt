package com.tabletop_assistant.feature_rng.viewmodel

import androidx.lifecycle.ViewModel
import com.tabletop_assistant.core_domain.entity.Dice
import com.tabletop_assistant.core_domain.usecase.RollDiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DiceScreenViewModel @Inject constructor(
	private val rollDiceUseCase: RollDiceUseCase
): ViewModel() {

	private var _diceRollResult = MutableStateFlow(Pair(0, 0))
	val diceRollResult: StateFlow<Pair<Int, Int>> = _diceRollResult.asStateFlow()

	fun rollDice(vararg dice: Dice) {
		val result = rollDiceUseCase(*dice)
		_diceRollResult.value = result
	}
}