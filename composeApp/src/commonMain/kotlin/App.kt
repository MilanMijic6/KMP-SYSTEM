import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.vega.di.apiModule
import com.vega.di.remoteModule
import com.vega.di.repositoryModule
import com.vega.di.settingsStorageModule
import com.vega.di.useCaseModule
import di.viewModelModule
import main.eventdetails.EventDetailsScreen
import org.koin.compose.KoinApplication
import splash.SplashScreen

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(
                viewModelModule + useCaseModule + repositoryModule + remoteModule + apiModule + settingsStorageModule
            )
        },
    ) {
        Navigator(
            screen = EventDetailsScreen()
        ) {
            SlideTransition(it)
        }
    }
}