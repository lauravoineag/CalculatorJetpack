package com.example.calculatorjetpack.actions

sealed class CalculatorOperation(val operator: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("*")
    object Divide: CalculatorOperation("/")

}
