package com.tabletop_assistant.feature_rng.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tabletop_assistant.domain.entity.Dice
import com.tabletop_assistant.feature_rng.viewmodel.DiceScreenViewModel
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun DiceScreenRoot(modifier: Modifier, viewModel: DiceScreenViewModel) {

	val result = viewModel.diceRollResult.collectAsState()


	LaunchedEffect(key1 = Unit) {
		val dice = List(Random.nextInt(1..4)) { Dice.SIX }
		viewModel.rollDice(*dice.toTypedArray())
	}

	DiceScreen(modifier = modifier, rollResult = result)
}

@Composable
private fun DiceScreen(
	modifier: Modifier,
	rollResult: State<Int>
) {
	Box(
		modifier = modifier
			.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Text(text = "${rollResult.value}")
	}
}
