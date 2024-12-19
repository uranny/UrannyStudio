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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.urannystudio.R
import com.example.urannystudio.ui.theme.UrannyStudioTheme
import com.example.urannystudio.value.Post
import com.example.urannystudio.value.Value

@Composable
fun Home(modifier : Modifier = Modifier){
    Surface(modifier = modifier.padding(start = 6.dp, end = 6.dp, top = 6.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(Value.postLst.filter { !it.fav }){ post ->
                Poto(post = post)
            }
        }
    }
}

@Composable
fun Poto(post: Post, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        PotoImg(
            post
        )
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 6.dp, top = 2.dp),
            text = post.ttl,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            maxLines = 1
        )
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 6.dp),
            text = post.ttl,
            fontSize = 12.sp,
            maxLines = 1
        )
    }
}

@Composable
fun PotoImg(
    post : Post,
    modifier: Modifier = Modifier
){
    var clickAble by remember { mutableStateOf(post.fav) }
    Box(modifier = modifier
        .fillMaxWidth(1f)
        .padding(start = 6.dp, end = 6.dp, top = 6.dp)
        .height(300.dp)
    ){
        // 이거 내 그림 사진
        Image(modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .clip(RoundedCornerShape(5.dp)),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "bookmark",
            contentScale = ContentScale.Crop)

        // 이거 북마크 에오
        Image(modifier = Modifier
            .width(40.dp)
            .height(50.dp)
            .align(Alignment.BottomEnd)
            .padding(6.dp)
            .clickable {
                clickAble = !clickAble
                post.fav = clickAble
                       },
            painter = if(clickAble){
                painterResource(id = R.drawable.baseline_bookmark_24)
            }
            else {
                painterResource(id = R.drawable.baseline_bookmark_border_24)
            },
            contentDescription = "bookmark",
            contentScale = ContentScale.Crop)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    UrannyStudioTheme {
        Home()
    }
}