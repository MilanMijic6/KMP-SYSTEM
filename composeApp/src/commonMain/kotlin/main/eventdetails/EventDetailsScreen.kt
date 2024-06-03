package main.eventdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import com.vega.domain.model.events.UpcomingEvent
import main.home.UpcomingEventsContract
import main.home.UpcomingEventsViewModel
import org.koin.compose.koinInject
import util.Loader

class EventDetailsScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: UpcomingEventsViewModel = koinInject()
        //todo remove later
        SuccessEventDetails(
            viewModel = viewModel,
            upcomingEvents = viewModel.viewState.value.upcomingEventListScreenModel.upcomingEvents
        )
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