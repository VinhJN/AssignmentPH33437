package com.vinhbqph33437.assignment.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vinhbqph33437.assignment.R
import com.vinhbqph33437.assignment.ui.theme.nunitosansFontFamily

@Composable
fun OrderSuccessScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SUCCESS!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            contentAlignment = Alignment.BottomCenter

        ) {
            Box(
                modifier = Modifier
                    .size(250.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.background_chair), // Replace with the correct image resource
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.Unspecified
                )
                Icon(
                    painter = painterResource(id = R.drawable.group), // Replace with the correct image resource
                    contentDescription = null,
                    modifier = Modifier.size(150.dp),
                    tint = Color.Unspecified
                )

            }
            Icon(
                painter = painterResource(id = R.drawable.checkmark_circle_fill), // Replace with the correct image resource
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .offset(x = 0.dp, y = 10.dp),
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your order will be delivered soon.\nThank you for choosing our app!",
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = nunitosansFontFamily,
            fontWeight = FontWeight(400)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* TODO: Handle Track Order */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(
                text = "Track your orders",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = nunitosansFontFamily,
                fontWeight = FontWeight(600)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                navController.navigate("Home") {
                    popUpTo("OrderSuccess") { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(10.dp),

            ) {
            Text(
                text = "BACK TO HOME",
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = nunitosansFontFamily,
                fontWeight = FontWeight(600)
            )
        }
    }
}
