package com.example.calculatorjetpack.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(symbol:String, onClick:()-> Unit, modifier: Modifier = Modifier, backgroundColour: Color = Color.White) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
        .clip(RoundedCornerShape(100.dp))
        .clickable { onClick() }
        .background(backgroundColour)
        .then(modifier)
    ) {
        Text(text = symbol,
            fontSize = 36.sp,
            color = Color.White)
    }
}

@Preview
@Composable
fun CalculatorButtonPreview(){
    CalculatorButton(symbol = "9", onClick = { /*TODO*/ })
}