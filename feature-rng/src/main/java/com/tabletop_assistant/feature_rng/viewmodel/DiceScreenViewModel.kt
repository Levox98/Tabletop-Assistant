package com.tabletop_assistant.feature_rng.viewmodel

import androidx.lifecycle.ViewModel
import com.tabletop_assistant.domain.entity.Dice
import com.tabletop_assistant.domain.usecase.RollDiceUseCase
import com.tabletop_assistant.domain.usecase.RollMultipleDiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DiceScreenViewModel @Inject constructor(
	private val rollDiceUseCase: RollDiceUseCase,
	private val rollMultipleDiceUseCase: RollMultipleDiceUseCase
): ViewModel() {

	private var _diceRollResult = MutableStateFlow(0)
	val diceRollResult: StateFlow<Int> = _diceRollResult.asStateFlow()

	fun rollDice(vararg dice: Dice) {
		if (dice.size == 1) {
			_diceRollResult.value = rollDiceUseCase(dice[0])
		} else {
			_diceRollResult.value = rollMultipleDiceUseCase(dice.toList())
		}
	}
}