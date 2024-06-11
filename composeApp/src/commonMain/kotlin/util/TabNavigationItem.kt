package util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import ui.ColorYellow
import ui.FontRegular
import ui.TextGray

@Composable
fun RowScope.TabNavigationItem(
    tab: Tab,
    onSelected: Boolean,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        selected = onSelected,
        onClick = { onClick() },
        label = {
            tab.options.title.let {
                Text(
                    text = it,
                    fontFamily = FontRegular(),
                    fontSize = 12.sp,
                    color = if (onSelected) ColorYellow else Color.White
                )
            }
        },
        icon = {
            tab.options.icon?.let {
                Image(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier
                        .size(38.dp),
                    colorFilter = ColorFilter.tint(
                        if (onSelected) ColorYellow
                        else TextGray
                    ),
                )
            }
        },
        selectedContentColor = ColorYellow,
        unselectedContentColor = Color.White,
        modifier = Modifier
            .background(Color.Transparent)
            .padding(
                top = 20.dp,
                bottom = 10.dp
            )
    )
}