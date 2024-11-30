package com.tabletop_assistant.feature_character.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tabletop_assistant.feature_character.viewmodel.CharacterScreenDisplayState
import com.tabletop_assistant.feature_character.viewmodel.CharacterScreenState
import com.tabletop_assistant.feature_character.viewmodel.CharacterViewModel
import com.tabletop_assistant.feature_character.viewmodel.CharacterViewModelIntent

@Composable
fun CharacterScreenRoot(
    modifier: Modifier,
    viewModel: CharacterViewModel
) {
    val vmState = viewModel.state.collectAsState()

    CharacterScreen(modifier, vmState, viewModel::collectIntent)
}

@Composable
private fun CharacterScreen(
    modifier: Modifier,
    state: State<CharacterScreenState>,
    onIntent: (CharacterViewModelIntent) -> Unit
) {

    val displayState = state.value.displayState

    LazyColumn(modifier = modifier) {

        item {
            Button(onClick = { onIntent(CharacterViewModelIntent.LoadClasses) }) {
                Text(text = "LOAD CLASSES")
            }
        }

        if (displayState is CharacterScreenDisplayState.Content) {
            items(displayState.raceList.size) {
                Button(onClick = {}) {
                    Text(text = displayState.raceList[it].name)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CharacterScreenPreview() {

    val mockState = CharacterScreenState(
        isLoading = false,
        error = null,
        displayState = CharacterScreenDisplayState.Content(listOf()),
    )

    CharacterScreen(modifier = Modifier, state = remember { mutableStateOf(mockState) }) {}
}