package util

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import ui.FontRegular

@Composable
fun LinkText(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = color,
        fontFamily = FontRegular(),
        fontSize = 16.sp,
        modifier = modifier
    )
}