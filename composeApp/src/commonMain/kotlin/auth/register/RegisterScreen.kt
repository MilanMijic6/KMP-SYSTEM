package auth.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import auth.login.LoginScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.anonymous_sign
import eventhubapplication.composeapp.generated.resources.email
import eventhubapplication.composeapp.generated.resources.login
import eventhubapplication.composeapp.generated.resources.name
import eventhubapplication.composeapp.generated.resources.password
import eventhubapplication.composeapp.generated.resources.sign_up
import main.MainScreen
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import ui.ColorLightGray
import ui.ColorPurple
import util.ClickableText
import util.DropdownMenu
import util.HeaderText
import util.PurpleButton
import util.RoundedTextInput
import util.RoundedTextInputPassword

class RegisterScreen : Screen {

    @Composable
    override fun Content() {
        val registerViewModel: RegisterViewModel = koinInject()
        val handleEvent: (RegisterContract.Event) -> Unit = { registerViewModel.handleEvents(it) }
        val navigator = LocalNavigator.currentOrThrow
        ShowMainContent(
            handleEvent = handleEvent
        )
        LaunchedEffect(Unit) {
            registerViewModel.effect.collect {
                when (it) {
                    RegisterContract.Effect.NavigateToMainScreen -> navigator.push(
                        MainScreen(
                            navigator
                        )
                    )
                    RegisterContract.Effect.NavigateToLoginScreen -> navigator.push(
                        LoginScreen()
                    )
                }
            }
        }
    }

    @Composable
    private fun ShowMainContent(
        handleEvent: (RegisterContract.Event) -> Unit
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
                    text = stringResource(Res.string.sign_up),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(
                            top = 30.dp,
                            bottom = 20.dp
                        )
                )
                DropdownMenu(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp
                        )
                ) {
                    handleEvent(
                        RegisterContract.Event.RoleEnterEvent(it)
                    )
                }
                RoundedTextInput(
                    modifier = Modifier
                        .padding(
                            top = 4.dp
                        ),
                    text = stringResource(Res.string.name)
                ) {
                    handleEvent(
                        RegisterContract.Event.NameEnterEvent(it)
                    )
                }
                RoundedTextInput(
                    modifier = Modifier
                        .padding(
                            top = 4.dp
                        ),
                    text = stringResource(Res.string.email)
                ) {
                    handleEvent(
                        RegisterContract.Event.EmailEnterEvent(it)
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
                        RegisterContract.Event.PasswordEnterEvent(it)
                    )
                }
                ClickableText(
                    text = stringResource(Res.string.anonymous_sign),
                    textAlign = TextAlign.Center,
                    color = ColorPurple,
                    modifier = Modifier
                        .padding(
                            top = 20.dp,
                            bottom = 40.dp
                        )
                ) {
                    handleEvent(
                        RegisterContract.Event.LoginAnonymouslyEvent
                    )
                }
                PurpleButton(
                    text = stringResource(Res.string.sign_up),
                    modifier = Modifier
                        .padding(
                            16.dp
                        )
                ) {
                    handleEvent(
                        RegisterContract.Event.RegisterUserEvent
                    )
                }
                ClickableText(
                    text = stringResource(Res.string.login),
                    textAlign = TextAlign.Center,
                    color = ColorPurple,
                    modifier = Modifier.padding(
                        bottom = 20.dp
                    )
                ) {
                    handleEvent(
                        RegisterContract.Event.LoginScreenEvent
                    )
                }
            }
        }
    }
}