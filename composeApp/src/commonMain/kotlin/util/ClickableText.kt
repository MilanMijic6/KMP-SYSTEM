package util

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ui.FontSemiBold

@Composable
fun ClickableText(
    text: String,
    color: Color,
    textAlign: TextAlign,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = color,
        fontFamily = FontSemiBold(),
        fontSize = 16.sp,
        textAlign = textAlign,
        modifier = modifier
    )
}