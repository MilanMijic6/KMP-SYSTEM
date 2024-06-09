package main.filter.event_filter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import ui.ColorPurple
import ui.ColorWhite
import ui.TextGray

@Composable
fun FilterEventTypeItem(
    event: Event,
    isSelected: Boolean,
    onClick: () -> Unit,
    size: Dp = 64.dp,
    iconSize: Dp = 30.dp
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size)
            .border(
                BorderStroke(
                    width = 1.dp,
                    color = TextGray
                ),
                shape = CircleShape
            )
            .background(
                color = if (isSelected) ColorPurple else ColorWhite,
                shape = CircleShape
            )
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(event.iconRes),
            contentDescription = null,
            tint = if (isSelected) ColorWhite else TextGray,
            modifier = Modifier
                .size(iconSize)
        )
    }
}