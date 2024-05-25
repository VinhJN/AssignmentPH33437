package com.vinhbqph33437.assignment.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.vinhbqph33437.assignment.R
import com.vinhbqph33437.assignment.ui.theme.Merriweather_bold
import com.vinhbqph33437.assignment.ui.theme.nunitosansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavController) {
    var promoCode by remember { mutableStateOf("") }
    var itemQuantities by remember {
        mutableStateOf(
            mapOf(
                "Minimal Stand" to 1, "Coffee Table" to 1, "Minimal Desk" to 1
            )
        )
    }

    val items = listOf(
        CartItem("Minimal Stand", 25.00, R.drawable.stand),
        CartItem("Coffee Table", 20.00, R.drawable.coffeetable),
        CartItem("Minimal Desk", 50.00, R.drawable.minidesk)
    )

    val totalAmount = items.sumOf { it.price * (itemQuantities[it.name] ?: 1) }

    Scaffold(topBar = {
        TopAppBar(title = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "My cart",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = Merriweather_bold,
                    fontWeight = FontWeight(700)
                )
            }
        }, navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        })
    }, content = { padding ->
        Column(modifier = Modifier.padding(padding)) {
            // Danh sách các mặt hàng
            Column(
                modifier = Modifier
                    .weight(1f) // Phần này có trọng số cao hơn, nên sẽ chiếm hết không gian còn lại của màn hình
                    .verticalScroll(rememberScrollState())
            ) {
                items.forEachIndexed { index, item ->
                    // Hiển thị sản phẩm
                    CartItemView(
                        item,
                        itemQuantities[item.name] ?: 1,
                        onQuantityChange = { quantity ->
                            itemQuantities = itemQuantities.toMutableMap().apply {
                                put(item.name, quantity)
                            }
                        })
                    // Thêm Divider nếu không phải là mục cuối cùng
                    if (index < items.size - 1) {
                        Divider(modifier = Modifier.padding(horizontal = 16.dp))
                    }
                }
            }
            // Phần footer cố định ở cuối trang
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                PromoCodeField(promoCode) { promoCode = it }
                Spacer(modifier = Modifier.height(16.dp))
                TotalAmount(totalAmount)
                Spacer(modifier = Modifier.height(16.dp))
                CheckoutButton(navController)
            }
        }
    })
}

@Composable
fun CartItemView(item: CartItem, quantity: Int, onQuantityChange: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.imageRes),
            contentDescription = item.name,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                item.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                fontFamily = nunitosansFontFamily,
                color = Color("#999999".toColorInt())
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "$${item.price}",
                fontSize = 16.sp,
                color = Color("#242424".toColorInt()),
                fontFamily = nunitosansFontFamily,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .background(
                            Color("#F0F0F0".toColorInt()), shape = RoundedCornerShape(6.dp)
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    IconButton(onClick = { if (quantity > 1) onQuantityChange(quantity - 1) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_minus),
                            contentDescription = "Decrease"
                        )
                    }
                }
                Text(
                    quantity.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = nunitosansFontFamily,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .background(
                            Color("#F0F0F0".toColorInt()), shape = RoundedCornerShape(6.dp)
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    IconButton(onClick = { onQuantityChange(quantity + 1) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_plus),
                            contentDescription = "Increase"
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* Handle item removal */ }) {
            Icon(
                Icons.Default.Close,
                contentDescription = "Remove item",
                Modifier.align(Alignment.Top)
            )
        }

    }
}

@Composable
fun PromoCodeField(promoCode: String, onPromoCodeChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp)
            .shadow(2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(58.dp)
                    .shadow(2.dp)
            ) {
                TextField(value = promoCode,
                    onValueChange = onPromoCodeChange,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 16.sp),
                    placeholder = { Text("Enter your promo code") })
            }
            Box(
                modifier = Modifier
                    .height(58.dp)
                    .shadow(2.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { }, modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "Apply promo code",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun TotalAmount(totalAmount: Double) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
    ) {
        Row {
            Text(
                text = "Total:",
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                fontFamily = nunitosansFontFamily,
                color = Color.Gray,
                textAlign = TextAlign.Start
            )
            Text(
                text = "$${totalAmount}",
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun CheckoutButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("CheckOut")
        },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth(),
    ) {
        Text(text = "Check out", fontSize = 16.sp, color = Color.White)
    }
}

data class CartItem(val name: String, val price: Double, val imageRes: Int)
