package com.example.fakestoreapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.ui.theme.FontDetailColor

@Composable
fun ImageCircles() {
    Box(
        modifier = Modifier
            .size(16.dp)
            .clip(CircleShape)
            .background(Color.Transparent)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = CircleShape
            )
    )
    Spacer(modifier = Modifier.width(8.dp))
    Box(
        modifier = Modifier
            .size(16.dp)
            .clip(CircleShape)
            .background(Color.Black)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = CircleShape
            )
            .padding(start = 10.dp, end = 10.dp)
    )
    Spacer(modifier = Modifier.width(8.dp))
    Box(
        modifier = Modifier
            .size(16.dp)
            .clip(CircleShape)
            .background(Color.Transparent)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = CircleShape
            )
    )
}

@Composable
fun ProductTitleDetail(safeProduct: Product) {
    Row(
        modifier = Modifier.padding(top = 15.dp, bottom = 10.dp)
    ) {
        Text(
            text = if (safeProduct.title.length > 30) {
                safeProduct.title.substring(0, 30) + "..."
            } else {
                safeProduct.title
            },
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "$${safeProduct.price}",
            fontWeight = FontWeight.Bold,
            color = FontDetailColor,
            style = MaterialTheme.typography.titleLarge
        )
    }
}


@Composable
fun ProductRatingDetail(safeProduct: Product){
    Row(modifier = Modifier.padding(bottom = 20.dp)) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "rating",
            tint = FontDetailColor
        )
        Text(
            text = " ${safeProduct.rating?.rate ?: 0.0}",
            color = FontDetailColor,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = " (${safeProduct.rating?.count ?: 0} Review)",
            color = FontDetailColor,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun ProductDescriptionDetail(safeProduct: Product){
    Text(
        text = "Details",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.titleSmall,
        fontSize = 19.sp
    )
    Text(
        text = safeProduct.description ?: "No description available",
        fontSize = 14.sp,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun BuyButton(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 20.dp, end = 20.dp, bottom = 40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(FontDetailColor)
            .clickable{

            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Buy now",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )
    }
}