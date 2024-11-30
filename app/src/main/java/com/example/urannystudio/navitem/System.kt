package com.example.urannystudio.navitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urannystudio.R

@Composable
fun System(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .padding(
                start = 12.dp,
                end = 12.dp,
                top = 12.dp,
                bottom = 12.dp
            )
    ) {
        Column(modifier = Modifier) {
            Row(modifier = Modifier){
                Image(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(CircleShape),
                    painter =
                    painterResource(id = R.drawable.ic_launcher_background) ,
                    contentDescription = "userImg"
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                    ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 6.dp,
                            ),
                        text = "유저이름",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(modifier = Modifier
                        .padding(
                            start = 6.dp,
                        ),
                        text = "소개 메세지dsafsdaf",
                        fontSize = 12.sp,
                        maxLines = 1,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun showSystem(modifier: Modifier = Modifier){
    System(modifier)
}