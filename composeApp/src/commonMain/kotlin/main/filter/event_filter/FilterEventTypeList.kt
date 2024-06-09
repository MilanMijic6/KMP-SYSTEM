package main.filter.event_filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_filter_type_food
import eventhubapplication.composeapp.generated.resources.ic_filter_type_music
import eventhubapplication.composeapp.generated.resources.ic_filter_type_paint
import eventhubapplication.composeapp.generated.resources.ic_filter_type_sport

@Composable
fun FilterList() {
    val events = listOf(
        Event("Sport", Res.drawable.ic_filter_type_sport),
        Event("Music", Res.drawable.ic_filter_type_music),
        Event("Paint", Res.drawable.ic_filter_type_paint),
        Event("Food", Res.drawable.ic_filter_type_food),
        Event("Politics", Res.drawable.ic_filter_type_food),
        Event("Politics", Res.drawable.ic_filter_type_food)
    )

    var selectedIndex by remember { mutableStateOf(-1) }

    Box(
        modifier = Modifier
            .padding(
                horizontal = 16.dp
            )
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(events) { event ->
                val index = events.indexOf(event)
                FilterEventTypeItem(
                    event = event,
                    isSelected = index == selectedIndex,
                    onClick = { selectedIndex = index }
                )
            }
        }
    }
}