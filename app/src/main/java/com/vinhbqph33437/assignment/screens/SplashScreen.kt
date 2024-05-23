package com.vinhbqph33437.assignment.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinhbqph33437.assignment.R
import com.vinhbqph33437.assignment.ui.theme.AssignmentTheme
import com.vinhbqph33437.assignment.ui.theme.gelasioFontFamily
import com.vinhbqph33437.assignment.ui.theme.nunitosansFontFamily

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Splash()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.lamps), // Thay thế bằng tài nguyên hình ảnh thực của bạn
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Spacer(modifier = Modifier.height(210.dp))

            Text(
                text = "MAKE YOUR",
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                fontFamily = gelasioFontFamily,
                color = Color(0xFF444444) // Màu văn bản
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "HOME BEAUTIFUL",
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                fontFamily = gelasioFontFamily,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "The best simple place where you \n \ndiscover most wonderful furnitures \n" +
                        " \n and make your home beautiful",
                fontSize = 17.sp,
                fontWeight = FontWeight(400),
                color = Color.Gray,
                fontFamily = nunitosansFontFamily,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                textAlign = TextAlign.Left,
            )


            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /*TODO: Add your onClick code here*/ },
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier
                    .padding(0.dp)
                    .height(48.dp)
                    .fillMaxWidth(),
            ) {
                Text(text = "Get Started", fontSize = 16.sp, color = Color.White, fontFamily = gelasioFontFamily)
            }
            Spacer(modifier = Modifier.height(100.dp))

        }
    }
}
