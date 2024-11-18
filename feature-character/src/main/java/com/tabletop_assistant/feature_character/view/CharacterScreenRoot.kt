package com.tabletop_assistant.feature_character.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.tabletop_assistant.feature_character.viewmodel.CharacterViewModel

@Composable
fun CharacterScreenRoot(
    modifier: Modifier,
    viewModel: CharacterViewModel
) {

    val vmState = viewModel.state.collectAsState()


}

@Composable
private fun CharacterScreen() {

}