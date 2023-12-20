package com.example.calculatorjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculatorjetpack.components.Calculator
import com.example.calculatorjetpack.ui.theme.CalculatorJetpackTheme

class MainActivity : ComponentActivity() {
    private val viewModel: CalculatorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorJetpackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state = viewModel.state
                    Calculator(
                        state = state, onAction = viewModel::onAction,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp), buttonSpacing = 8.dp
                    )
                }
            }
        }
    }
}