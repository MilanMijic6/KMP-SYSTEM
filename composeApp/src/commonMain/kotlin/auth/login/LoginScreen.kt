package auth.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.email
import eventhubapplication.composeapp.generated.resources.log_in
import eventhubapplication.composeapp.generated.resources.password
import eventhubapplication.composeapp.generated.resources.sign_in_anonymous
import main.MainScreen
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import ui.ColorLightGray
import ui.ColorPurple
import util.ClickableText
import util.HeaderText
import util.PurpleButton
import util.RoundedTextInput
import util.RoundedTextInputPassword

class LoginScreen : Screen {

    @Composable
    override fun Content() {
        val loginViewModel: LoginViewModel = koinInject()
        val handleEvent: (LoginContract.Event) -> Unit = { loginViewModel.handleEvents(it) }
        val navigator = LocalNavigator.currentOrThrow
        ShowMainContent(handleEvent)
        LaunchedEffect(Unit) {
            loginViewModel.effect.collect {
                when (it) {
                    LoginContract.Effect.NavigateToMainScreen -> navigator.push(MainScreen(navigator))
                }
            }
        }
    }

    @Composable
    private fun ShowMainContent(
        handleEvent: (LoginContract.Event) -> Unit
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            color = ColorLightGray
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderText(
                    text = stringResource(Res.string.log_in),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(
                            top = 30.dp,
                            bottom = 10.dp
                        )
                )
                RoundedTextInput(
                    modifier = Modifier
                        .padding(
                            top = 10.dp
                        ),
                    text = stringResource(Res.string.email)
                ) {
                    handleEvent(
                        LoginContract.Event.EmailEnterEvent(it)
                    )
                }
                RoundedTextInputPassword(
                    modifier = Modifier
                        .padding(
                            top = 4.dp
                        ),
                    text = stringResource(Res.string.password)
                ) {
                    handleEvent(
                        LoginContract.Event.PasswordEnterEvent(it)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(80.dp)
                )
                PurpleButton(
                    text = stringResource(Res.string.log_in),
                    modifier = Modifier
                        .padding(
                            16.dp
                        )
                ) {
                    handleEvent(
                        LoginContract.Event.LoginUserEvent
                    )
                }
                ClickableText(
                    text = stringResource(Res.string.sign_in_anonymous),
                    textAlign = TextAlign.Center,
                    color = ColorPurple,
                    modifier = Modifier
                        .padding(
                            bottom = 20.dp
                        )
                ) {
                    handleEvent(
                        LoginContract.Event.LoginAnonymouslyEvent
                    )
                }
            }
        }
    }
}