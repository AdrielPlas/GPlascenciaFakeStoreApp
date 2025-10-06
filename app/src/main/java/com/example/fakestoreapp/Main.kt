package com.example.fakestoreapp

import android.provider.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(){
    GlobalScope.launch {
        SaludoAsincrono()
    }
    runBlocking { //Bloquea el hilo principal
        println("Hola desde run")
    }
}

suspend fun SaludoAsincrono(){
    println("hola")
    delay(2000)
    println("Listo")
}

suspend fun cAsync(){
    runBlocking {
        val result = async(Dispatchers.Main) {
            println("Buscando Products")
        }
        println("El resultado es: ${result.await()}")
    }
}

fun MyGlobal(){
    GlobalScope.launch {
        SaludoAsincrono()
    }
}

fun cWithContext(){
    runBlocking {
        val result = withContext(Dispatchers.IO){
            println("Consultando Info de API")
            delay(2000)
            print("Datos obtenidos")
            "{age: 17}"
        }
        println("El resultado es: $result")
    }
}