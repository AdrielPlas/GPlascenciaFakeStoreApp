package com.example.fakestoreapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fakestoreapp.ui.theme.BackgroundProductCard
import com.example.fakestoreapp.ui.theme.FontItemColor

@Composable
fun FilterButton(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp, bottom = 25.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(end = 14.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Black)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "All",
                color = Color.White
            )
        }
        Box(
            modifier = Modifier
                .padding(end = 14.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 2.dp,
                    color = BackgroundProductCard,
                    shape = RoundedCornerShape(10.dp)
                )
                .background(Color.White)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Nike",
                color = FontItemColor
            )
        }
        Box(
            modifier = Modifier
                .padding(end = 14.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 2.dp,
                    color = BackgroundProductCard,
                    shape = RoundedCornerShape(10.dp)
                )
                .background(Color.White)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Adidas",
                color = FontItemColor
            )
        }
        Box(
            modifier = Modifier
                .padding(end = 14.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 2.dp,
                    color = BackgroundProductCard,
                    shape = RoundedCornerShape(10.dp)
                )
                .background(Color.White)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Converse",
                color = FontItemColor
            )
        }

    }
}