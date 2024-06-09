package main.filter.date_time_filter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.ColorPurple
import ui.ColorWhite
import ui.FontRegular
import ui.TextGray

@Composable
fun TimeFilterButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .clickable(
                onClick = onClick
            ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            width = 1.dp,
            color = TextGray)
        ,
        color = if (isSelected) ColorPurple else ColorWhite,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(
                    vertical = 14.dp,
                    horizontal = 20.dp
                )
        ) {
            Text(
                text = text,
                color = if (isSelected) ColorWhite else TextGray,
                fontSize = 16.sp,
                fontFamily = FontRegular()
            )
        }
    }
}