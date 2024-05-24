package com.vinhbqph33437.assignment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vinhbqph33437.assignment.screens.ProductDetailScreen
import com.vinhbqph33437.assignment.screens.HomeScreen
import com.vinhbqph33437.assignment.screens.LoginScreen
import com.vinhbqph33437.assignment.screens.RegisterScreen
import com.vinhbqph33437.assignment.screens.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "Home") {

        composable(route = "Splash") {
            SplashScreen(navController)
        }

        composable(route = "Login") {
            LoginScreen(navController)
        }

        composable(route = "SignUp") {
            RegisterScreen(navController)
        }

        composable(route = "Home") {
            HomeScreen()
        }

        composable(route = "Detail") { backStackEntry ->
            ProductDetailScreen(navController)
        }
    }
}
