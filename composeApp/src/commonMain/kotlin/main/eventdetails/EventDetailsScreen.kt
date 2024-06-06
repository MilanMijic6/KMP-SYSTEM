package main.eventdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import com.vega.domain.model.events.UpcomingEvent
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.event_image
import main.home.UpcomingEventsContract
import main.home.UpcomingEventsViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import ui.ColorGreen
import ui.ColorRed
import ui.ColorWhite
import util.EventListItem
import util.Loader

class EventDetailsScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: UpcomingEventsViewModel = koinInject()
        //todo remove later
        Column {
            EventListItem(
                imageResource = Res.drawable.event_image,
                labelText = "Internation Band Music Concert",
                iconLabelText = "36 Guild Street London, UK",
                titleColor = Color.White,
                textInBoxFirstLabel = "10",
                textInBoxSecondLabel = "JUNE",
                backgroundColor = ColorRed
            )

            EventListItem(
                imageResource = Res.drawable.event_image,
                labelText = "Internation Band Music Concert",
                iconLabelText = "36 Guild Street London, UK",
                titleColor = Color.White,
                textInBoxFirstLabel = "18",
                textInBoxSecondLabel = "JUNE",
                backgroundColor = ColorGreen
            )

            EventListItem(
                imageResource = Res.drawable.event_image,
                labelText = "Internation Band Music Concert",
                iconLabelText = "36 Guild Street London, UK",
                titleColor = Color.Black,
                textInBoxFirstLabel = "10",
                textInBoxSecondLabel = "JULY",
                backgroundColor = ColorWhite
            )
        }
        /*SuccessEventDetails(
            viewModel = viewModel,
            upcomingEvents = viewModel.viewState.value.upcomingEventListScreenModel.upcomingEvents
        )*/
        /*when (val state = viewModel.viewState.value) {
            is UpcomingEventsContract.State.Error -> {
                //todo handle error loading
            }

            is UpcomingEventsContract.State.Init -> {
                Loader()
            }

            is UpcomingEventsContract.State.Success -> {
                SuccessEventDetails(
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
        }*/
    }
}