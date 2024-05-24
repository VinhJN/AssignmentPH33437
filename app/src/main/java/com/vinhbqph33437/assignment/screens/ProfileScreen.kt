package com.vinhbqph33437.assignment.screens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vinhbqph33437.assignment.navigation.BottomNavigationBar
import com.vinhbqph33437.assignment.navigation.NavigationItem
import com.vinhbqph33437.assignment.navigation.getRouteForIndex
import com.vinhbqph33437.assignment.ui.theme.AssignmentTheme

class ProfileScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                ProFileNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProFileNavigation() {
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { ProfileScreenContent() },
        bottomBar = {
            BottomNavigationBar(selectedTab = selectedTab) { index ->
                selectedTab = index
                navController.navigate(getRouteForIndex(index)) {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationHostProfile(navController)
        }
    }
}

@Composable
fun NavigationHostProfile(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) { HomeContent() }
        composable(NavigationItem.Favorites.route) { FavoriteScreenContent() }
        composable(NavigationItem.Notification.route) { NotificationScreenContent() }
        composable(NavigationItem.Profile.route) { ProfileScreenContent() }
    }
}
@Composable
fun ProfileScreenContent() {
    Text(text = "Profile Screen")
}
