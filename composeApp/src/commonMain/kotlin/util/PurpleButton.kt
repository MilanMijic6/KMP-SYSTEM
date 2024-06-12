package util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.ColorPurple
import ui.FontBold
import ui.TextGray

@Composable
fun PurpleButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = { }
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(),
        enabled = enabled,
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(10.dp),
        onClick = {
            if (enabled) onClick()
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = if (enabled) ColorPurple else TextGray
                )
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text,
                color = Color.White,
                fontFamily = FontBold(),
                fontSize = 16.sp
            )
        }
    }
}