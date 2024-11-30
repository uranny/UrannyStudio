package com.example.urannystudio

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urannystudio.navitem.Add
import com.example.urannystudio.navitem.Home
import com.example.urannystudio.navitem.System
import com.example.urannystudio.ui.theme.UrannyStudioTheme


@Composable
fun Main(modifier: Modifier = Modifier){

    val itemLst = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Search", Icons.Default.Search),
        NavItem("Add", Icons.Default.Add),
        NavItem("Like", Icons.Default.Favorite),
        NavItem("Setting", Icons.Default.Settings)
    )

    var selected by remember { mutableStateOf(0) }
    var showAdd by remember { mutableStateOf(false)}

    val context = LocalContext.current
    var backPressedTime = 0L



    BackHandler(enabled = true) {
        if(showAdd){
            showAdd = false
        } else if(System.currentTimeMillis() - backPressedTime <= 400L){
            (context as Activity).finish()
        } else{
            Toast.makeText(context, "뒤로가기 버튼을 한번더 눌러주세요", Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
    
    Box(modifier = Modifier.fillMaxSize()){
        Scaffold(
            topBar = {
                if(!showAdd){
                    Box(modifier= Modifier
                        .fillMaxWidth(1f)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 12.dp, top = 18.dp, end = 12.dp, bottom = 18.dp)
                                .align(Alignment.CenterStart),
                            text = "UrannyStudio",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                } else{
                    Box(
                        modifier = Modifier.fillMaxWidth(1f)
                    ){
                        IconButton(
                            modifier = Modifier
                                .padding(start = 4.dp, top = 8.dp, end = 12.dp, bottom = 8.dp)
                                .align(Alignment.CenterStart),
                            onClick = {showAdd = false}
                        ){
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backIcon" )
                        }
                    }
                }
            },
            bottomBar = {
                if(!showAdd){
                    BottomAppBar(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                            .background(Color.White)
                    ) {
                        itemLst.forEachIndexed { index, navItem ->
                            if(index == 1){
                                IconButton(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(CircleShape),
                                    onClick = { showAdd = true }
                                ) {
                                    Icon(
                                        modifier = Modifier,
                                        imageVector = navItem.img,
                                        contentDescription = navItem.label
                                    )
                                }
                            } else {
                                NavigationBarItem(
                                    selected = index == selected,
                                    onClick = {
                                        selected = index
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = navItem.img,
                                            contentDescription = navItem.label
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        ) { paddingValues ->
            if (showAdd){
                Add(modifier = Modifier.padding(paddingValues)){
                    showAdd = false
                }
            }else{
                ShowScreen(
                    modifier = Modifier.padding(paddingValues),
                    index = selected
                )
            }
        }
    }
}

@Composable
fun ShowScreen(modifier: Modifier, index : Int){
    when(index){
        0 -> Home(modifier)
        2 -> System(modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
    UrannyStudioTheme {
        Main()
    }
}