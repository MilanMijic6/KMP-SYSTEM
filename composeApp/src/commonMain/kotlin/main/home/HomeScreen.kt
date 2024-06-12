package main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.vega.domain.model.events.UpcomingEvent
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.event_image
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.koinInject
import ui.ColorGreen
import ui.ColorRed
import ui.ColorWhite
import util.EventListItem
import util.Loader

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: UpcomingEventsViewModel = koinInject()
        when (val state = viewModel.viewState.value) {
            is UpcomingEventsContract.State.Error -> {
                //remove later
                SuccessLoaded(
                    viewModel = viewModel,
                    upcomingEvents = state.upcomingEventListScreenModel.upcomingEvents
                )
            }

            is UpcomingEventsContract.State.Init -> {
                Loader()
            }

            is UpcomingEventsContract.State.Success -> {
                SuccessLoaded(
                    viewModel = viewModel,
                    upcomingEvents = state.upcomingEventListScreenModel.upcomingEvents
                )
            }
        }
        LaunchedEffect(Unit) {
            viewModel.handleEvents(UpcomingEventsContract.Event.ShowUpcomingEvents(0, 10))
            viewModel.effect.collect { effect ->
                when (effect) {
                    is UpcomingEventsContract.Effect.NavigateToEventDetailsScreen -> {
                        //todo handle navigation on click
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun SuccessLoaded(
        viewModel: UpcomingEventsViewModel,
        upcomingEvents: List<UpcomingEvent>
    ) {
        Column(
            modifier = Modifier
                .padding(end = 26.dp)
                .fillMaxHeight(),
        ) {
            /*CryptoList(
                cryptoList = upcomingEvents
            ) {
                viewModel.handleEvents(UpcomingEventsContract.Event.SelectUpcomingEventItem(it))
            }*/
            Column {
                EventListItem(
                    imageResource = Res.drawable.event_image,
                    labelText = "Internation Band Music Concert",
                    iconLabelText = "36 Guild Street London, UK",
                    titleColor = Color.White,
                    textInBoxFirstLabel = "10",
                    textInBoxSecondLabel = "JUNE",
                    itemWidth = 149,
                    backgroundColor = ColorRed
                )

                EventListItem(
                    imageResource = Res.drawable.event_image,
                    labelText = "Internation Band Music Concert",
                    iconLabelText = "36 Guild Street London, UK",
                    titleColor = Color.White,
                    textInBoxFirstLabel = "18",
                    textInBoxSecondLabel = "JUNE",
                    itemWidth = 255,
                    backgroundColor = ColorGreen
                )

                EventListItem(
                    imageResource = Res.drawable.event_image,
                    labelText = "Internation Band Music Concert",
                    iconLabelText = "36 Guild Street London, UK",
                    titleColor = Color.Black,
                    textInBoxFirstLabel = "10",
                    textInBoxSecondLabel = "JULY",
                    itemWidth = 149,
                    backgroundColor = ColorWhite
                )
            }
        }
    }
}