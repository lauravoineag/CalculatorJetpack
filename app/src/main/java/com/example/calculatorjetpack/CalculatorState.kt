package com.example.calculatorjetpack

import com.example.calculatorjetpack.actions.CalculatorOperation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)
