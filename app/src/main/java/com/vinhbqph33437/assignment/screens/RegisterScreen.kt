package com.vinhbqph33437.assignment.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.vinhbqph33437.assignment.R
import com.vinhbqph33437.assignment.ui.theme.Merriweather_bold
import com.vinhbqph33437.assignment.ui.theme.Merriweather_regular
import com.vinhbqph33437.assignment.ui.theme.nunitosansFontFamily

@Composable
fun RegisterScreen() {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_login),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(16.dp)
            )
            Divider(
                modifier = Modifier.weight(1f)
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "WELCOME",
                fontSize = 28.sp,
                color = Color.Black,
                fontFamily = Merriweather_bold,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.Start)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Button(
                onClick = {
                    if (email.isNotBlank() || password.isNotBlank()) {
                        Toast.makeText(
                            context, "Login successful", Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            context, "Please enter username and password", Toast.LENGTH_LONG
                        ).show()
                    }
                },
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(containerColor = Color("#303030".toColorInt())),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(vertical = 25.dp)
            ) {
                Text(text = "SIGN UP",
                    fontFamily = nunitosansFontFamily,
                    fontWeight = FontWeight.W600,
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
            TextButton(onClick = { /* Handle sign up */ }) {
                Text(
                    text = "Already have account? ",
                    fontFamily = nunitosansFontFamily,
                    fontWeight = FontWeight.W600,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    text = "SIGN IN",
                    fontFamily = nunitosansFontFamily,
                    fontWeight = FontWeight.W600,
                    color = Color("#303030".toColorInt()),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}