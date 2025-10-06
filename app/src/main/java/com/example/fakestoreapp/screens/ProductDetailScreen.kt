package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.fakestoreapp.components.BuyButton
import com.example.fakestoreapp.components.ImageCircles
import com.example.fakestoreapp.components.ProductDescriptionDetail
import com.example.fakestoreapp.components.ProductRatingDetail
import com.example.fakestoreapp.components.ProductTitleDetail
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.services.ProductService
import com.example.fakestoreapp.ui.theme.BackgroundProductCard
import com.example.fakestoreapp.ui.theme.HomeScreenRoute
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Composable
fun ProductDetailScreen(id : Int, navController: NavController) {
    var product by remember {
        mutableStateOf<Product?>(null)
    }

    LaunchedEffect(true) {
        try {
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(ProductService::class.java)
            val result = withContext(Dispatchers.IO){
                service.getProductById(id)
            }
            product = result
            Log.i("ProductDetailScreen", product.toString())
        }
        catch (e: Exception){
            Log.e("ProductDetailSceen", e.toString())
        }
    }
    // Inicio de UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .padding(5.dp)
            .background(BackgroundProductCard)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 35.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
        ) {
            // Botones de arriba
            Row(
                modifier = Modifier.weight(1f).padding(bottom = 30.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f).fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .clickable{
                                navController.popBackStack()
                            },
                        tint = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "favorite",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                    )
                }
            }
            // Imagen ejemplo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundProductCard)
                    .padding(10.dp)
                    .weight(4f),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = product?.image,
                    contentDescription = product?.description,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            // 3 Circulos de imagens
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .weight(1f),
            ) {
                ImageCircles()
            }
        }
        // Parte descriptiva
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
        ) {
            product?.let { safeProduct ->

                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .weight(1f)
                ) {
                    ProductTitleDetail(safeProduct)
                    ProductRatingDetail(safeProduct)
                    ProductDescriptionDetail(safeProduct)
                }

                BuyButton()

            } ?: run {
                // Mostrar mensaje de error
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Cargando producto...")
                }
            }
        }
    }
    /*
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(id.toString())
    } */
}