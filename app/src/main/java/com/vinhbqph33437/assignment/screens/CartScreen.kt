import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinhbqph33437.assignment.R
import com.vinhbqph33437.assignment.ui.theme.merriweatherFontFamily
import com.vinhbqph33437.assignment.ui.theme.nunitosansFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCart()
        }
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCart() {
    var promoCode by remember { mutableStateOf("") }
    var itemQuantities by remember { mutableStateOf(mapOf("Minimal Stand" to 1, "Coffee Table" to 1, "Minimal Desk" to 1)) }

    val items = listOf(
        CartItem("Minimal Stand", 25.00, R.drawable.stand),
        CartItem("Coffee Table", 20.00, R.drawable.coffeetable),
        CartItem("Minimal Desk", 50.00, R.drawable.minidesk)
    )

    val totalAmount = items.sumOf { it.price * (itemQuantities[it.name] ?: 1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "My cart",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontFamily = merriweatherFontFamily,
                            fontWeight = FontWeight(700)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                // Danh sách các mặt hàng
                Column(
                    modifier = Modifier
                        .weight(1f) // Phần này có trọng số cao hơn, nên sẽ chiếm hết không gian còn lại của màn hình
                        .verticalScroll(rememberScrollState())
                ) {
                    items.forEachIndexed { index, item ->
                        // Hiển thị sản phẩm
                        CartItemView(item, itemQuantities[item.name] ?: 1, onQuantityChange = { quantity ->
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
                    CheckoutButton()
                }
            }
        }
    )
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
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(item.name, fontSize = 16.sp)
            Text("$${item.price}", fontSize = 14.sp, color = Color.Gray)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { if (quantity > 1) onQuantityChange(quantity - 1) }) {
                    Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Decrease quantity")
                }
                Text(quantity.toString(), fontSize = 16.sp)
                IconButton(onClick = { onQuantityChange(quantity + 1) }) {
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Increase quantity")
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* Handle item removal */ }) {
            Icon(Icons.Default.Close, contentDescription = "Remove item", Modifier.align(Alignment.Top))
        }

    }
}

@Composable
fun PromoCodeField(promoCode: String, onPromoCodeChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .shadow(2.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(58.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                    )
                    .shadow(2.dp)  // Add shadow for border
            ) {
                TextField(
                    value = promoCode,
                    onValueChange = onPromoCodeChange,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 16.sp),
                    placeholder = { Text("Enter your promo code") }
                )
            }
            Box(
                modifier = Modifier
                    .height(58.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                    )
                    .shadow(2.dp)
                    .background(Color.Black)
            ){
                IconButton(
                    onClick = { /* Handle promo code application */ },
                    modifier = Modifier.size(48.dp)
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
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
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
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun CheckoutButton() {
    Button(
        onClick = {
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
