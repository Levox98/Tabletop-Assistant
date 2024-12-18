package com.tabletop_assistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tabletop_assistant.core_ui.theme.TabletopAssistantTheme
import com.tabletop_assistant.feature_character.view.CharacterScreenRoot
import com.tabletop_assistant.feature_character.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	private val viewModel: CharacterViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			TabletopAssistantTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//					Greeting(
//						name = "Android",
//						modifier = Modifier.padding(innerPadding)
//					)

//					DiceScreenRoot(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
					CharacterScreenRoot(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	TabletopAssistantTheme {
		Greeting("Android")
	}
}