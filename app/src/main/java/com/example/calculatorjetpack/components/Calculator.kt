package com.example.calculatorjetpack.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorjetpack.CalculatorState
import com.example.calculatorjetpack.actions.CalculatorOperation

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier:Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)) {
            Text(
                text = state.number1 + (state.operation?.operator ?: "") + state.number2,
                textAlign = TextAlign.End,
                fontSize = 80.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp, horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    Calculator(state = CalculatorState("1", "2",CalculatorOperation.Add))
}