package com.example.p6_composestate

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MutableStateInsideComposebleWithoutRemember(checkedState: MutableState<Boolean>) {
    val checkedValue = checkedState.value
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(8.dp)
        ) {
            Checkbox(
                checked = checkedValue,
                onCheckedChange =  { value -> checkedState.value = value },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Текст...",
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
        if (checkedValue) {
            Text(
                text = "Много какого-то текста...",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(8.dp)
                )
        }
    }
}