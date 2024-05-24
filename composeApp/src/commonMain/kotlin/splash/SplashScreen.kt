package splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import auth.register.RegisterScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import eventhubapplication.composeapp.generated.resources.Res
import eventhubapplication.composeapp.generated.resources.ic_logo
import main.MainScreen
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

class SplashScreen : Screen {

    @Composable
    override fun Content() {
        val splashScreenViewModel: SplashViewModel = koinInject()
        val navigator = LocalNavigator.currentOrThrow
        ShowSplashContent()
        LaunchedEffect(Unit) {
            splashScreenViewModel.effect.collect {
                when (it) {
                    SplashContract.Effect.NavigateToRegisterScreen -> navigator.push(RegisterScreen(navigator))
                    SplashContract.Effect.NavigateToMainScreen -> navigator.push(MainScreen(navigator))
                }
            }
        }
    }
}

@Composable
private fun ShowSplashContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_logo),
                contentDescription = "Logo image"
            )
        }
    }
}