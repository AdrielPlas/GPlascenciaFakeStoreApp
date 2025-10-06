package com.example.fakestoreapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// Callback

fun main(){
    val a = 1
    val b = 2
    val resultSum = suma(a, b)
    val resultREst = resta(a, b)
    operacionDeNumeros(a, b, operacion = { a,b -> suma(a, b)})

}

fun suma(a : Int, b: Int): Int  {
    return a + b
}

fun resta(a : Int, b: Int): Int  {
    return a - b
}

fun operacionDeNumeros(a: Int, b: Int, operacion: (Int, Int) -> Int){
    println("El numero a vale: $a")
    println("El numero b vale :$b")
    val result = operacion(a,b)
    println("$result")
}

@Composable
fun BookCard(onClick : () -> Unit) {
    Column(
        modifier = Modifier
            .clickable{
                onClick()
            }
    ) {

    }
}