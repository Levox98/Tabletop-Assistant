package com.tabletop_assistant.feature_rng.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tabletop_assistant.core_domain.entity.Dice
import com.tabletop_assistant.feature_rng.viewmodel.DiceScreenViewModel

@Composable
fun DiceScreenRoot(modifier: Modifier, viewModel: DiceScreenViewModel) {

	val result = viewModel.diceRollResult.collectAsState()

	DiceScreen(modifier = modifier, rollResult = result, onRollClick = { viewModel.rollDice(*it.toTypedArray()) })
}

@Composable
private fun DiceScreen(
	modifier: Modifier,
	rollResult: State<Pair<Int, Int>>,
	onRollClick: (dice: List<Dice>) -> Unit
) {
	Box(
		modifier = modifier
			.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Column {
			Text(text = "${rollResult.value.first} / ${rollResult.value.second}")

			Button(onClick = { onRollClick(listOf(Dice(6), Dice(4), Dice(20))) }) {
				Text(text = "Roll")
			}
		}
	}
}
