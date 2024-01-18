import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import presentation.Login.LoginScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Navigator(LoginScreen()) {
                SlideTransition(it)
            }
        }
    }
}