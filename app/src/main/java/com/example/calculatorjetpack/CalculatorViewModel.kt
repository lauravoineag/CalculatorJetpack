package com.example.calculatorjetpack

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculatorjetpack.actions.CalculatorAction
import com.example.calculatorjetpack.actions.CalculatorOperation
import java.nio.file.Files.delete

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when(action) {
            CalculatorAction.Calculate -> calculate()
            CalculatorAction.Clear -> state = CalculatorState()
            CalculatorAction.Decimal -> enterDecimal()
            CalculatorAction.Delete -> deleteLast()
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
        }
    }

    private fun deleteLast() {
        when {
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))
            state.operation != null  -> state = state.copy(operation = null)
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        TODO("Not yet implemented")
    }

    private fun enterNumber(number: Int) {
        TODO("Not yet implemented")
    }

    private fun enterDecimal() {
        TODO("Not yet implemented")
    }

    private fun calculate() {
        TODO("Not yet implemented")
    }
}