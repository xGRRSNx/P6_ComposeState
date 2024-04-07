package com.example.p6_composestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircleItem()
            }
        }
    }
}

@Composable
fun CircleItem() {
    val counter = remember { mutableStateOf(0) }
    val color = remember { mutableStateOf(Color.Red) }
    val colors = listOf(
        "Red", "Orange", "Yellow", "Green", "Light Blue", "Blue", "Purple"
    )
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {
                color.value = when (counter.value % colors.size) {
                    0 -> Color(0xFFFF7B00)
                    1 -> Color.Yellow
                    2 -> Color.Green
                    3 -> Color(0xFF00B7FF)
                    4 -> Color.Blue
                    5 -> Color(0xFF7300B5)
                    6 -> Color.Red
                    else -> Color.Black
                }
                counter.value++
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
        ) {
            Text(
                text = counter.value.toString(),
                style = TextStyle(color = Color.White, fontSize = 20.sp),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = colors[counter.value % colors.size],
                style = TextStyle(color = Color.White, fontSize = 16.sp),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
