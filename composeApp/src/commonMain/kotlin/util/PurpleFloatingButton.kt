package util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ui.ColorPurple

@Composable
fun PurpleFloatingButton(
    isCreator: Boolean = false,
    onClick: () -> Unit = { }
) {
    if (isCreator) {
        FloatingActionButton(
            onClick = { onClick() },
            containerColor = ColorPurple
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = Color.White
            )
        }
    }
}