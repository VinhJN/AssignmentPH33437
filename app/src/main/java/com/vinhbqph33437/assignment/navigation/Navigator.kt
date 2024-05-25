package com.vinhbqph33437.assignment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vinhbqph33437.assignment.screens.CartScreen
import com.vinhbqph33437.assignment.screens.CheckOutScreen
import com.vinhbqph33437.assignment.screens.ProductDetailScreen
import com.vinhbqph33437.assignment.screens.HomeScreen
import com.vinhbqph33437.assignment.screens.LoginScreen
import com.vinhbqph33437.assignment.screens.OrderSuccessScreen
import com.vinhbqph33437.assignment.screens.RegisterScreen
import com.vinhbqph33437.assignment.screens.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "Splash") {

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
            HomeScreen(navController)
        }


        composable(route = "Detail") { backStackEntry ->
            ProductDetailScreen(navController)
        }
        composable(route = "Cart") {
            CartScreen(navController)
        }

        composable(route = "CheckOut") {
            CheckOutScreen(navController)
        }

        composable(route = "OrderSuccess") {
            OrderSuccessScreen(navController)
        }
    }
}
