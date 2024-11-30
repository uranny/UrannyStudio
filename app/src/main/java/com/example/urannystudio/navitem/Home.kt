package com.example.urannystudio.navitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urannystudio.R
import com.example.urannystudio.ui.theme.UrannyStudioTheme

@Composable
fun Home(modifier : Modifier = Modifier){
    val potoLst = List(5){"$it"}
    Surface(modifier = modifier.padding(start = 6.dp, end = 6.dp, top = 6.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(potoLst){poto ->
                Poto(name = poto)
            }
        }
    }
}

@Composable
fun Poto(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        PotoImg(uri = "zzzzzzzzzzzzzzzzzzzzzzzzzzzz")
        UserProfile(uri = "^-^", userName = "내 그림이무니당")
    }
}

@Composable
fun PotoImg(uri : String, modifier: Modifier = Modifier){
    var clickAble by remember { mutableStateOf(false) }
    Box(modifier = modifier
        .fillMaxWidth(1f)
        .padding(start = 6.dp, end = 6.dp, top = 6.dp, bottom = 4.dp)
        .height(300.dp)
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
        .background(Color.White)
    ){
        Image(modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .clip(RoundedCornerShape(5.dp)),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "bookmark",
            contentScale = ContentScale.Crop)

        Image(modifier = Modifier
            .width(40.dp)
            .height(50.dp)
            .align(Alignment.BottomEnd)
            .padding(6.dp)
            .clickable { clickAble = !clickAble },
            painter = if(clickAble){ painterResource(id = R.drawable.baseline_bookmark_24) } else {
                painterResource(id = R.drawable.baseline_bookmark_border_24)
            },
            contentDescription = "bookmark",
            contentScale = ContentScale.Crop)
    }
}

@Composable
fun UserProfile(uri : String, userName : String , modifier: Modifier = Modifier ){
    Row(modifier = modifier
        .padding(start = 6.dp, bottom = 6.dp)
        .fillMaxSize(1f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(modifier = Modifier
            .width(30.dp)
            .height(30.dp)
            .clip(CircleShape),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            alignment = Alignment.BottomEnd)

        Text(modifier = Modifier.
        padding(start = 6.dp),
            text = userName,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    UrannyStudioTheme {
        Home()
    }
}