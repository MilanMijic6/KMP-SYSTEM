package util

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.FontSemiBold

@OptIn(ExperimentalResourceApi::class)
@ExperimentalMaterial3Api
@Composable
fun TopBarHeader(
    title: String,
    onIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 32.sp,
                fontFamily = FontSemiBold(),
                color = Color.Black
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
        modifier = Modifier
            .background(
                color = Color.White
            )
    )
}