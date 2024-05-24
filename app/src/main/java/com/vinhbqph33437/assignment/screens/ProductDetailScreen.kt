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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.vinhbqph33437.assignment.R
import com.vinhbqph33437.assignment.ui.theme.gelasioFontFamily
import  com.vinhbqph33437.assignment.ui.theme.nunitosansFontFamily

@Composable
fun ProductDetailScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(480.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.minimal_stand_detail),
                contentDescription = "Minimal Stand",
                modifier = Modifier
                    .width(340.dp)
                    .height(480.dp)
                    .align(Alignment.CenterEnd),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .padding(33.dp)
                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(4.dp))
                    .size(40.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center,
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 130.dp, horizontal = 20.dp)
                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(40.dp))
                    .height(230.dp)
                    .width(64.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Button(
                        onClick = { /* TODO: Handle color selection */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .shadow(4.dp, RoundedCornerShape(20.dp))
                    ) {}
                    Button(
                        onClick = { /* TODO: Handle color selection */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color("#B4916C".toColorInt())),
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .shadow(4.dp, RoundedCornerShape(20.dp))
                    ) {}
                    Button(
                        onClick = { /* TODO: Handle color selection */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color("#E4CBAD".toColorInt())),
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .shadow(4.dp, RoundedCornerShape(20.dp))
                    ) {}
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                "Minimal Stand",
                fontSize = 24.sp,
                fontWeight = FontWeight.W500,
                fontFamily = gelasioFontFamily
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "$ 50", fontSize = 30.sp, fontWeight = FontWeight.W700, fontFamily = nunitosansFontFamily
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .background(
                                Color("#F0F0F0".toColorInt()), shape = RoundedCornerShape(10.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_minus),
                            contentDescription = "Minus",
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Text(
                        "1",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W500,
                        fontFamily = nunitosansFontFamily
                    )
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .background(
                                Color("#F0F0F0".toColorInt()), shape = RoundedCornerShape(10.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_plus),
                            contentDescription = "Plus",
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Minimal Stand is made of by natural wood. The design is modern and minimalist. It is suitable for your living room or your working space.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = nunitosansFontFamily,
                lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* TODO: Handle add to cart */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Add to Cart",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = nunitosansFontFamily
                )
            }
        }
    }
}