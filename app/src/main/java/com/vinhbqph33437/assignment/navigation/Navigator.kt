

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vinhbqph33437.assignment.screens.LoginScreen
import com.vinhbqph33437.assignment.screens.SplashScreenContent

object Navigator {
    @Composable
    fun SetupNavigation() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "splash") {
            composable("splash") {
                SplashScreenContent(navController)
            }
            composable("login") {
                LoginScreen(navController)
            }
            // Add more screens here if needed
        }
    }
}
