package com.example.fakestoreapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestoreapp.ui.theme.BackgroundProductCard

@Composable
fun SearchBar (){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
    ) {
        TextField(
            placeholder = {
                Text(
                    text = "Search",
                    fontSize = 18.sp
                )
            },
            value = "",
            onValueChange = { },
            singleLine = true,
            enabled = true,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .weight(1f)
                .border(
                    width = 2.dp,
                    color = BackgroundProductCard,
                    shape = RoundedCornerShape(10.dp)
                )
            //.height(40.dp)
        )
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier
                .padding(start = 5.dp)
                .size(55.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Black)
                .padding(8.dp),
            tint = Color.White
        )
    }
}