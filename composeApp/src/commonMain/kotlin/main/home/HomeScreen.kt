package main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import auth.login.LoginScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.vega.domain.model.events.UpcomingEvent
import main.eventdetails.EventDetailsScreen
import org.koin.compose.koinInject
import util.CenteredDialog
import util.Loader

class HomeScreen(
    val navigator: Navigator
) : Screen {

    @Composable
    override fun Content() {
        val viewModel: UpcomingEventsViewModel = koinInject()
        val shouldShowDialog = remember { mutableStateOf(false) }
        if (shouldShowDialog.value) {
            CenteredDialog(
                title = "You need to be logged in!",
                buttonText = "Login",
                descriptionText = "Dismiss",
                onNegativeClick = {
                    shouldShowDialog.value = false
                },
                onPositiveClick = {
                    shouldShowDialog.value = false
                    viewModel.handleEvents(UpcomingEventsContract.Event.ClickOnDialogButtonEvent)
                }
            )
        }
        when (val state = viewModel.viewState.value) {
            is UpcomingEventsContract.State.Error -> {
                //todo handle error
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
                        navigator.push(EventDetailsScreen(
                            id = effect.eventId
                        ))
                    }
                    UpcomingEventsContract.Effect.ShowLoginDialog -> {
                        shouldShowDialog.value = true
                    }
                    UpcomingEventsContract.Effect.NavigateToLoginScreen -> {
                        navigator.push(LoginScreen())
                    }
                }
            }
        }
    }

    @Composable
    private fun SuccessLoaded(
        viewModel: UpcomingEventsViewModel,
        upcomingEvents: List<UpcomingEvent>
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            GridList(
                upcomingEvents = upcomingEvents
            ) {
                viewModel.handleEvents(UpcomingEventsContract.Event.SelectUpcomingEventItem(it))
            }
        }
    }
}