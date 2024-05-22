package auth.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import util.DropdownMenu
import util.HeaderText
import util.PurpleButton
import util.RoundedTextInput
import util.RoundedTextInputPassword

class RegisterScreen(
    val navigator: Navigator
) : Screen {

    @Composable
    override fun Content() {
        ShowMainContent(navigator = navigator)
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
                    text = "Sign Up",
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
                )
                RoundedTextInput(
                    modifier = Modifier
                        .padding(
                            top = 4.dp
                        ),
                    text = "Name"
                ) {

                }
                RoundedTextInput(
                    modifier = Modifier
                        .padding(
                            top = 4.dp
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
                ClickableText(
                    text = "Anonymous sign?",
                    textAlign = TextAlign.Center,
                    color = ColorPurple,
                    modifier = Modifier
                        .padding(
                            top = 20.dp,
                            bottom = 40.dp
                        )
                )
                PurpleButton(
                    text = "Sign Up",
                    modifier = Modifier
                        .padding(
                            16.dp
                        )
                )
                ClickableText(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    color = ColorPurple,
                    modifier = Modifier.padding(
                        bottom = 20.dp
                    )
                )
            }
        }
    }
}