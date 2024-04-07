package com.example.p6_composestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf

class MainActivity : ComponentActivity() {
    private val checkedState = mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MutableStateInsideComposebleWithoutRemember(checkedState)
        }
    }
}
