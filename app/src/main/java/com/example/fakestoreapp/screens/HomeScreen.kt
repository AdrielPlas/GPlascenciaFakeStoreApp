package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fakestoreapp.components.FilterButton
import com.example.fakestoreapp.components.ProductCard
import com.example.fakestoreapp.components.SearchBar
import com.example.fakestoreapp.components.productCardTest
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.services.ProductService
import com.example.fakestoreapp.ui.theme.FakeStoreAppTheme
import com.example.fakestoreapp.ui.theme.ProductDetailScreenRoute
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Composable
fun HomeScreen(navController: NavController){
    var products by remember {
        mutableStateOf(listOf<Product>())
    }
    var loading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(true) {
        try {
            // Crear instancia de REtrofit CREATE
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(ProductService::class.java)
            val result = async(Dispatchers.IO) {
                service.getAllProducts()
            }
            Log.i("HomeScreen","${result.await()}")
            products = result.await()
            loading = false
        } catch (e: Exception){
            loading = false
            Log.e("HomeScreen",e.toString())
        }
    }

    if (loading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
    else {
        // INICIO DEL UI
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(25.dp)
        ) {
            // Row de bienvenida
            Row(modifier = Modifier.padding(top = 20.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Hi Adriel",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Good Morning!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                // Imagen de perfil
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                        .padding(8.dp),
                    tint = Color.DarkGray
                )

            }
            // Barra de busqeuda
            SearchBar()

            // Botones de filtrado
            FilterButton()


            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(products) { product ->
                    ProductCard(
                        product = product,
                        onClick = {
                            navController.navigate(ProductDetailScreenRoute(product.id))
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    FakeStoreAppTheme {
        HomeScreen(rememberNavController())
    }
}