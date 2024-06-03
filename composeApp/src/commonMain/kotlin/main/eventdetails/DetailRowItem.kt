package main.eventdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ui.ColorLightPurple
import ui.ColorPurple
import ui.ColorPurple75
import ui.FontRegular
import ui.TextGray

@Composable
fun DetailRowItem(
    modifier: Modifier = Modifier,
    iconResId: DrawableResource,
    topText: String,
    bottomText: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = modifier
                .size(48.dp)
                .background(
                    color = ColorLightPurple,
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(iconResId),
                contentDescription = null,
                tint = ColorPurple,
                modifier = Modifier
                    .size(30.dp)
            )
        }
        Column {
            Text(
                modifier = Modifier.padding(
                    top = 2.dp
                ),
                text = topText,
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontRegular()
            )
            Text(
                modifier = Modifier.padding(
                    top = 5.dp
                ),
                text = bottomText,
                color = TextGray,
                fontSize = 12.sp,
                fontFamily = FontRegular()
            )
        }
    }
}