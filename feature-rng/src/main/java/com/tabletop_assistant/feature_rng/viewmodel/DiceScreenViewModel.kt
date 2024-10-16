package com.tabletop_assistant.feature_rng.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DiceScreenViewModel @Inject constructor(
): ViewModel() {

	private var _diceRollResult = MutableStateFlow(0)
	val diceRollResult: StateFlow<Int> = _diceRollResult.asStateFlow()

	fun rollDice() {}
}