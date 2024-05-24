package util

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import ui.FontRegular

@Composable
fun LinkText(
    text: String,
    color: Color,
    textAlign: TextAlign,
    textSize: TextUnit = 16.sp,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = color,
        fontFamily = FontRegular(),
        fontSize = textSize,
        textAlign = textAlign,
        modifier = modifier
    )
}