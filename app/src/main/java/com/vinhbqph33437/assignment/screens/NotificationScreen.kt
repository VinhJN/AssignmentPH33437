package com.vinhbqph33437.assignment.screens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vinhbqph33437.assignment.ui.theme.AssignmentTheme

class NotificationScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                NotificationScreenContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationScreenContent() {
    Text(text = "Notification Screen")
}
