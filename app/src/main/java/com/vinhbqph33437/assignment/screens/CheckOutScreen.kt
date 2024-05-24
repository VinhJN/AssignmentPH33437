import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinhbqph33437.assignment.R
import com.vinhbqph33437.assignment.ui.theme.nunitosansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutPage() {
    var shippingAddress by remember { mutableStateOf("Bruno Fernandes\n25 rue Robert Latouche, Nice, 06200, Côte D’azur, France") }
    var paymentMethod by remember { mutableStateOf("**** **** **** 3947") }
    var deliveryMethod by remember { mutableStateOf("Fast (2-3 days)") }
    var orderAmount by remember { mutableStateOf("$95.00") }
    var deliveryAmount by remember { mutableStateOf("$5.00") }
    var totalAmount by remember { mutableStateOf("$100.00") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "Check out", textAlign = TextAlign.Center)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "Back", modifier = Modifier.size(20.dp))
                    }
                }

            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .background(Color.White)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Shipping Address",
                    fontFamily = nunitosansFontFamily,
                    fontSize = 18.sp,
                )
                Spacer(modifier = Modifier.width(170.dp)) // Adjust the space as needed
                Image(
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "EditProduct",
                    modifier = Modifier.size(24.dp),
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(127.dp)
                    .padding(vertical = 8.dp)
                    .shadow(2.dp)  // Add shadow for border
                    .padding(8.dp)
            ) {
                Column {
                    Text(
                        text = "Bruno Fernandes",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = nunitosansFontFamily,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Divider(
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = nunitosansFontFamily,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Payment",
                    fontFamily = nunitosansFontFamily,
                    fontSize = 18.sp,
                )
                Spacer(modifier = Modifier.width(250.dp)) // Adjust the space as needed
                Image(
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "EditProduct",
                    modifier = Modifier.size(24.dp),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(vertical = 8.dp)
                        .shadow(2.dp)  // Add shadow for border
                        .padding(8.dp)
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.card),
                            contentDescription = "Mastercard",
                            modifier = Modifier
                                .width(64.dp)
                                .height(38.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = paymentMethod,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            fontFamily = nunitosansFontFamily
                            )
                    }
                }
            }

            Spacer(modifier = Modifier.height(25.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Delivery method",
                    fontFamily = nunitosansFontFamily,
                    fontSize = 18.sp,
                )
                Spacer(modifier = Modifier.width(180.dp)) // Adjust the space as needed
                Image(
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "EditProduct",
                    modifier = Modifier.size(24.dp),
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(vertical = 8.dp)
                    .shadow(2.dp)  // Add shadow for border
                    .padding(8.dp)
            ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dhl),
                    contentDescription = "DHL",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = deliveryMethod,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = nunitosansFontFamily,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .padding(vertical = 8.dp)
                    .shadow(2.dp)  // Add shadow for border
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            ){

            Column {
                Row {
                    Text(
                        text = "Order:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = nunitosansFontFamily,
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "$orderAmount",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        textAlign = TextAlign.End
                    )
                }
                Row {
                    Text(
                        text = "Delivery: ",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = nunitosansFontFamily,
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "$deliveryAmount",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        textAlign = TextAlign.End
                    )
                }
                Row {
                    Text(
                        text = "Total:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = nunitosansFontFamily,
                        modifier = Modifier.padding(10.dp),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "$totalAmount",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        textAlign = TextAlign.End
                    )
                }
            }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier
                    .padding(0.dp)
                    .height(48.dp)
                    .fillMaxWidth(),
            ) {
                Text(text = "Submit Order", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckOutScreenPreview() {
    CheckoutPage()
}
