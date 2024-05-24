package main.myevents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import ui.ColorLightGray

class MyEventsScreen() : Screen {

    @Composable
    override fun Content() {
        ShowMainContent()
    }

    @Composable
    private fun ShowMainContent(
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = ColorLightGray
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "My events Screen")
            }
        }
    }
}