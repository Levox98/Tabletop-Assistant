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
import com.tabletop_assistant.feature_character.viewmodel.CharacterViewModel
import com.tabletop_assistant.feature_character.viewmodel.CharacterViewModelIntent
import com.tabletop_assistant.feature_character.viewmodel.CharacterViewModelState

@Composable
fun CharacterScreenRoot(
    modifier: Modifier,
    viewModel: CharacterViewModel
) {
    val vmState = viewModel.state.collectAsState()

    CharacterScreen(modifier, vmState, viewModel::collectIntent)
}

@Composable
private fun CharacterScreen(modifier: Modifier, state: State<CharacterViewModelState>, onIntent: (CharacterViewModelIntent) -> Unit) {
    val indices = state.value.indexList

    LazyColumn(modifier = modifier) {

        item {
            Button(onClick = { onIntent(CharacterViewModelIntent.LoadClasses) }) {
                Text(text = "LOAD CLASSES")
            }
        }

        indices?.let {
            items(indices.size) {
                Button(onClick = {}) {
                    Text(text = indices[it])
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CharacterScreenPreview() {
    val mockState = CharacterViewModelState(
        isLoading = false,
        error = null,
        indexList = listOf("human", "not human", "very human", "somewhat human")
    )

    CharacterScreen(modifier = Modifier, state = remember { mutableStateOf(mockState) }) {}
}