package main.eventdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.compose.koinInject
import util.CenteredDialog
import util.Loader

class EventDetailsScreen(
    val id: String
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: EventDetailsViewModel = koinInject()
        val handleEvent: (EventDetailsContract.Event) -> Unit = { viewModel.handleEvents(it) }
        val shouldShowDialog = remember { mutableStateOf(false) }

        if (shouldShowDialog.value) {
            CenteredDialog(
                title = "Something went wrong",
                buttonText = "Dismiss",
                descriptionText = "Dismiss",
                onNegativeClick = {
                    shouldShowDialog.value = false
                },
                onPositiveClick = {
                    shouldShowDialog.value = false
                }
            )
        }

        when (val state = viewModel.viewState.value) {
            is EventDetailsContract.State.Error -> {
                shouldShowDialog.value = true
            }

            is EventDetailsContract.State.Init -> {
                Loader()
            }

            is EventDetailsContract.State.LoadedSuccessEvent -> {
                SuccessEventDetails(
                    event = state.eventDetailsModel.eventDetails,
                    handleEvent = handleEvent
                )
            }
            is EventDetailsContract.State.Reserve -> {
                navigator.pop()
            }
        }
        LaunchedEffect(Unit) {
            viewModel.handleEvents(EventDetailsContract.Event.ShowEventDetails(id = id))
            viewModel.effect.collect {
                when (it) {
                    EventDetailsContract.Effect.NavigateBack -> navigator.pop()
                }
            }
        }
    }
}