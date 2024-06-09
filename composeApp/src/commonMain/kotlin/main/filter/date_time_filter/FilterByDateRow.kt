package main.filter.date_time_filter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_arrow_right
import eventhubapplication.composeapp.generated.resources.ic_tab_calendar
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ui.ColorPurple
import ui.FontRegular
import ui.TextGray

@Composable
fun FilterByDateRow(
    icon: DrawableResource,
    modifier: Modifier = Modifier,
    borderColor: Color = TextGray,
    height: Int = 48,
    text: String,
    textColor: Color = TextGray,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(
                horizontal = 16.dp
            )
            .height(height.dp)
            .border(
                BorderStroke(
                    width = 1.dp,
                    color = borderColor
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    start = 16.dp
                )
                .size(34.dp),
            tint = ColorPurple
        )

        Text(
            text = text,
            modifier = Modifier
                .padding(
                    horizontal = 28.dp
                ),
            fontSize = 18.sp,
            fontFamily = FontRegular(),
            color = textColor
        )

        Icon(
            painter = painterResource(Res.drawable.ic_arrow_right),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    end = 16.dp
                )
                .size(16.dp),
            tint = ColorPurple
        )
    }
}