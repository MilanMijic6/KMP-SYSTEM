package main.eventdetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_back_arrow
import org.jetbrains.compose.resources.painterResource
import ui.FontRegular

@Composable
fun Header(
    title: String,
    onBackClick: () -> Unit
) {
    Row {
        IconButton(
            onClick = onBackClick
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_back_arrow),
                contentDescription = "Back",
                tint = Color.White
            )
        }
        Text(
            text = title,
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = FontRegular(),
            modifier = Modifier.padding(
                start = 8.dp,
                top = 4.dp
            )
        )
    }
}