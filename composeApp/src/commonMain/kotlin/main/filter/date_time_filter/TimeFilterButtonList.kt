package main.filter.date_time_filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterButtonList() {
    var selectedButton by remember { mutableStateOf("Today") }

    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TimeFilterButton(
            text = "Today",
            isSelected = selectedButton == "Today",
            onClick = { selectedButton = "Today" }
        )
        TimeFilterButton(
            text = "Tomorrow",
            isSelected = selectedButton == "Tomorrow",
            onClick = { selectedButton = "Tomorrow" }
        )
        TimeFilterButton(
            text = "This Week",
            isSelected = selectedButton == "This Week",
            onClick = { selectedButton = "This Week" }
        )
    }
}