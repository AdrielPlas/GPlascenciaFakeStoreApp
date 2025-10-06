package com.example.fakestoreapp.models

import android.media.Rating

class Product(
    val id : Int,
    val title : String,
    val price : Double,
    val description : String,
    val category : String,
    val image : String,
    val rating : com.example.fakestoreapp.models.Rating
)