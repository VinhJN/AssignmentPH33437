package com.vinhbqph33437.assignment.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.vinhbqph33437.assignment.screens.NavigationItem

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black
    ) {
        val items = listOf("Home", "Favorites", "Notifications", "Profile")
        val icons = listOf(
            Icons.Filled.Home,
            Icons.Filled.Favorite,
            Icons.Filled.Notifications,
            Icons.Filled.Person
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    unselectedIconColor = Color.Black,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}

fun getRouteForIndex(index: Int): String {
    return when (index) {
        0 -> NavigationItem.Home.route
        1 -> NavigationItem.Favorites.route
        2 -> NavigationItem.Notifications.route
        3 -> NavigationItem.Profile.route
        else -> NavigationItem.Home.route
    }
}
