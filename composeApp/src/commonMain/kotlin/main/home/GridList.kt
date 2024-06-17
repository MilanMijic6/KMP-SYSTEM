package main.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vega.domain.model.events.UpcomingEvent
import convertBase64ToBitmap
import ui.ColorWhite
import util.EventListItem

@Composable
fun GridList(
    upcomingEvents: List<UpcomingEvent>,
    onItemClicked: (String) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(
            upcomingEvents.size
        ) { index ->
            val item = upcomingEvents[index]
            EventListItem(
                bitmap = convertBase64ToBitmap(item.image),
                labelText = item.name,
                iconLabelText = item.address,
                titleColor = Color.Black,
                textInBoxFirstLabel = item.dateDay,
                textInBoxSecondLabel = item.dateMonth.uppercase(),
                itemWidth = 180,
                backgroundColor = ColorWhite,
                contentModifier = Modifier
                    .clickable {
                        onItemClicked(item.id.toString())
                    }
            )
        }
    }
}