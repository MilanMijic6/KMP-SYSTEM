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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import ui.ColorPurple
import util.ClickableText
import util.HeaderText
import util.PurpleButton
import util.RoundedTextInput
import util.RoundedTextInputPassword

class LoginScreen(
    val navigator: Navigator
) : Screen {

    @Composable
    override fun Content() {
        ShowMainContent(
            navigator = navigator
        )
    }

    @Composable
    private fun ShowMainContent(
        navigator: Navigator
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderText(
                    text = "Log In",
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
                    text = "Email"
                ) {

                }
                RoundedTextInputPassword(
                    modifier = Modifier
                        .padding(
                            top = 4.dp
                        ),
                    text = "Password"
                ) {

                }
                Spacer(
                    modifier = Modifier
                        .height(80.dp)
                )
                PurpleButton(
                    text = "Log In",
                    modifier = Modifier
                        .padding(
                            16.dp
                        )
                )
                ClickableText(
                    text = "Sign in anonymously?",
                    textAlign = TextAlign.Center,
                    color = ColorPurple,
                    modifier = Modifier
                        .padding(
                            bottom = 20.dp
                        )
                )
            }
        }
    }
}