package com.example.fakestoreapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.models.Rating
import com.example.fakestoreapp.ui.theme.BackgroundProductCard
import com.example.fakestoreapp.ui.theme.FakeStoreAppTheme

@Composable
fun ProductCard(
    product: Product,
    onClick : () -> Unit
){
    Column(
        modifier = Modifier
            .width(120.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onClick()
            }
    ) {

        // Imagen
        Box(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(BackgroundProductCard)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = product.description,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Información del producto
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Text(
                text = product.title,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().padding(top = 3.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "$${product.price}",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

    /*
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clip(CircleShape)
            .background(Color.Cyan)
            .padding(10.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = product.image,
            contentDescription = product.title,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)
        ) {
            Text(product.title)
            Text(product.category)
        }
        Text("$${product.price}")
    }*/
}

@Composable
fun testUI(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(25.dp)
    ) {
        Row (

        ){
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Hi Adriel",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Good Morning!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
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
    }
}

@Composable
fun productCardTest(
    product: Product,
    onClick : () -> Unit
){
    Column(
        modifier = Modifier
            .height(120.dp)
            .clickable {
                onClick()
            }
    ) {
        AsyncImage(
            model = product.image,
            contentDescription = product.description,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = product.title
        )
        Text(
            text = "$${product.price}",
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview
@Composable
fun ProductCardPreview(){
    val testProduct = Product(
        id = 1,
        title = "Camiseta de prueba",
        price = 19.99,
        description = "Camiseta cómoda y de alta calidad.",
        category = "Ropa",
        image = "https://ejemplo.com/camiseta.png",
        rating = Rating(rate = 4.5, count = 120)
    )
    FakeStoreAppTheme {
       /* ProductCard(
            product = testProduct,
            onClick = {}
        ) */
        testUI()
    }
}