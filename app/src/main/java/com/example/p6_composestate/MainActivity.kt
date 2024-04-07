package com.example.p6_composestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val clicks = mutableStateOf(0)
        setContent {
            ClickCount(i = clicks, lambdaCallback = { clicks.value++ })
        }
    }
}


@Composable
fun ClickCount(i: State<Int>, lambdaCallback: () -> Unit) {
    val clicksCount = i.value
    Text(
        text = "Clicks: $clicksCount",
        modifier = Modifier.clickable(onClick = lambdaCallback),
        fontSize = 25.sp
    )
}
