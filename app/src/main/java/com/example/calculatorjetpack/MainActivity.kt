package com.example.calculatorjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.calculatorjetpack.actions.CalculatorOperation
import com.example.calculatorjetpack.components.Calculator
import com.example.calculatorjetpack.ui.theme.CalculatorJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorJetpackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator(state = CalculatorState("1", "2", CalculatorOperation.Add), onAction = {})
                }
            }
        }
    }
}