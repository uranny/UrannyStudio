package com.example.urannystudio.navitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.urannystudio.value.Value

@Composable
fun BookMark(modifier : Modifier) {
    Surface(modifier = modifier
        .padding(
            start = 6.dp,
            end = 6.dp,
            top = 6.dp
        )
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(Value.postLst.filter { it.fav }){ post->
                Poto(post = post)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowBookMark(modifier: Modifier = Modifier){
    BookMark(modifier = modifier)
}