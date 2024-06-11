package util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ui.ColorPurple
import ui.FontRegular
import ui.TextGray

@Composable
fun CenteredDialog(
    title: String,
    buttonText: String,
    descriptionText: String,
    onPositiveClick: () -> Unit = { },
    onNegativeClick: () -> Unit = { }
) {
    Dialog(
        onDismissRequest = {
            onNegativeClick()
        }
    ) {
        Box(
            modifier = Modifier
                .size(
                    width = 230.dp,
                    height = 300.dp
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 16.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = TextGray,
                    fontFamily = FontRegular()
                )
                PurpleButton(
                    text = buttonText,
                    modifier = Modifier
                        .padding(
                            vertical = 8.dp
                        )
                ) {
                    onPositiveClick()
                }
                ClickableText(
                    text = descriptionText,
                    textAlign = TextAlign.Center,
                    color = ColorPurple,
                    modifier = Modifier
                        .padding(
                            top = 20.dp
                        )
                ) {
                    onNegativeClick()
                }
            }
        }
    }
}