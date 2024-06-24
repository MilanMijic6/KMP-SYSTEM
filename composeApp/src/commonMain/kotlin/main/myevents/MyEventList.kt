package main.myevents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vega.domain.model.my_events.MyEvent
import convertBase64ToBitmap
import ui.ColorGreen
import ui.ColorRed
import ui.ColorWhite
import ui.FontRegular
import util.EventListItem

@Composable
fun MyEventList(
    events: List<MyEvent>,
    title: String,
    isPastEvent: Boolean = false,
    onItemClicked: (String) -> Unit
) {
    Column {
        Text(
            text = title,
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                    horizontal = 16.dp
                ),
            color = Color.Black,
            fontSize = 24.sp,
            fontFamily = FontRegular()
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = 16.dp
            )
        ) {
            items(
                events.size
            ) { index ->
                val item = events[index]
                EventListItem(
                    bitmap = convertBase64ToBitmap(item.image),
                    labelText = item.name,
                    iconLabelText = item.address,
                    titleColor = Color.Black,
                    textInBoxFirstLabel = item.dateDay,
                    textInBoxSecondLabel = item.dateMonth.uppercase(),
                    itemWidth = 240,
                    backgroundColor = if (isPastEvent) ColorWhite else getEventBackgroundColor(item),
                    contentModifier = Modifier
                        .clickable {
                            onItemClicked(item.id.toString())
                        }
                )
            }
        }
    }
}

@Composable
private fun getEventBackgroundColor(event: MyEvent): Color {
    return when (event.status) {
        "Rejected" -> ColorRed
        "Pending" -> ColorWhite
        "Approved" -> ColorGreen
        else -> ColorWhite
    }
}