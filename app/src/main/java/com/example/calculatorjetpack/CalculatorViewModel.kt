package com.example.calculatorjetpack

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculatorjetpack.actions.CalculatorAction
import com.example.calculatorjetpack.actions.CalculatorOperation

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
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
            state.operation != null -> state = state.copy(operation = null)
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank() && state.operation == null) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation != null) {
            state = state.copy(number2 = state.number2 + number.toString())
        }
        if (state.operation == null) {
            state = state.copy(number1 = state.number1 + number.toString())
        }
    }

    private fun enterDecimal() {
        if (state.number1.isNotBlank() && state.operation == null && !state.number1.contains(".")) {
            state = state.copy(number1 = state.number1 + ".")
        }
        if (state.number2.isNotBlank() && !state.number2.contains(".")) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number2 != null && number1 != null) {
            val result = when (state.operation) {
                CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Subtract -> number1 - number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Divide -> number1 / number2
                null -> return
            }
            state = CalculatorState(number1 = result.toString().take(15))
        }
    }
}