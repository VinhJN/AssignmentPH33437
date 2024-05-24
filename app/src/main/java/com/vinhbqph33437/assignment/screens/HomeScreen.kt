package com.vinhbqph33437.assignment.screens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.vinhbqph33437.assignment.R
import com.vinhbqph33437.assignment.navigation.BottomNavigationBar
import com.vinhbqph33437.assignment.navigation.getRouteForIndex
import com.vinhbqph33437.assignment.ui.theme.AssignmentTheme
import com.vinhbqph33437.assignment.ui.theme.gelasioFontFamily
import com.vinhbqph33437.assignment.ui.theme.nunitosansFontFamily

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                MyApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CustomTopAppBar() },
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
            NavigationHost(navController)
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) { HomeContent() }
        composable(NavigationItem.Favorites.route) { FavoriteScreenContent() }
        composable(NavigationItem.Notifications.route) { NotificationScreenContent() }
        composable(NavigationItem.Profile.route) { ProfileScreenContent() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Make home",
                        color = Color.Gray,
                        fontWeight = FontWeight(400),
                        fontSize = 18.sp,
                        fontFamily = gelasioFontFamily
                    )
                    Text(
                        text = "BEAUTIFUL",
                        color = Color.Black,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                        fontFamily = gelasioFontFamily
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Cart",
                        tint = Color.Gray
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
        )
    )
}

@Composable
fun HomeContent() {
    val categoryIcons = listOf<ImageBitmap>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        ProductCategoryRow(categoryIcons)
        Spacer(modifier = Modifier.height(16.dp))
        ProductList()
    }
}

@Composable
fun ProductCategoryRow(categoryIcons: List<ImageBitmap>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val categories = listOf("Popular", "Chair", "Table", "Armchair", "Bed", "Lamp")
        categories.forEachIndexed { index, category ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(if (category == "Popular") Color.Black else Color.Gray.copy(alpha = 0.1f))
                ) {
                    val icon = categoryIcons.getOrNull(index)
                    if (icon != null) {
                        Image(
                            bitmap = icon,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Text(
                            text = category.first().toString(),
                            color = if (category == "Popular") Color.White else Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = category,
                    fontSize = 12.sp,
                    color = if (category == "Popular") Color.White else Color.Black
                )
            }
        }
    }
}

@Composable
fun ProductList() {
    val products = listOf(
        Product("Black Simple Lamp", "$12.00", R.drawable.simple_lamp),
        Product("Minimal Stand", "$25.00", R.drawable.stand),
        Product("Coffee Chair", "$20.00", R.drawable.chair),
        Product("Simple Desk", "$50.00", R.drawable.desk)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
    ) {
        val rows = products.chunked(2)
        rows.forEachIndexed { index, row ->
            ProductRow(row)
            if (index < rows.size - 1) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ProductRow(products: List<Product>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        products.forEach { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(width = 157.dp, height = 253.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color.Gray.copy(alpha = 0.1f))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 180.dp, height = 200.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.Gray.copy(alpha = 0.1f))
                ) {
                    Image(
                        painter = painterResource(id = product.imageRes),
                        contentDescription = product.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    IconButton(
                        onClick = { /* Handle favorite button click */ },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Favorite",
                            tint = Color.Gray
                        )
                    }
                }
                Text(
                    text = product.name,
                    fontWeight = FontWeight(400),
                    fontFamily = nunitosansFontFamily,
                    fontSize = 14.sp,
                    maxLines = 1,
                    color = Color.Gray,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Text(
                    text = product.price,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

data class Product(val name: String, val price: String, val imageRes: Int)

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Filled.Home, "Home")
    object Favorites : NavigationItem("favorites", Icons.Filled.Favorite, "Favorites")
    object Notifications : NavigationItem("notifications", Icons.Filled.Notifications, "Notifications")
    object Profile : NavigationItem("profile", Icons.Filled.Person, "Profile")
}
