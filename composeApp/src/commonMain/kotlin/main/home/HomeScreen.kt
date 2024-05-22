package main.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen

class HomeScreen() : Screen {

    @Composable
    override fun Content() {
        ShowMainContent()
    }

    @Composable
    private fun ShowMainContent(
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Home Screen",
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }
}