package com.example.urannystudio.navitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.urannystudio.R
import com.example.urannystudio.ui.theme.UrannyStudioTheme

@Composable
fun Add(modifier: Modifier = Modifier, callBack: () -> Unit){
    val context = LocalContext.current
    var ttlTxt by remember { mutableStateOf("") }
    var ttlVis by remember { mutableStateOf(false) }
    var cntTxt by remember { mutableStateOf("") }
    var cntVis by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()){
        Surface(modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
        ) {
            val scrollState = rememberScrollState()
            Column(modifier = Modifier
                .verticalScroll(scrollState)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(350.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    painter = painterResource(id = R.drawable.ic_launcher_background, ),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .fillMaxWidth(1f),
                    value = ttlTxt,
                    onValueChange = { ttlTxt = it
                        ttlVis = ttlTxt.isNotBlank() },
                    label = { Text("제목을 입력해주세요")},
                    singleLine = true,
                    trailingIcon = {
                        if(ttlVis){
                            IconButton(
                                onClick = {
                                    ttlTxt = ""
                                    ttlVis = false
                                }
                            ) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = "clear")
                            }
                        }
                    }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .fillMaxWidth(1f),
                    value = cntTxt,
                    onValueChange = { cntTxt = it
                        cntVis = cntTxt.isNotBlank() },
                    label = { Text("내용을 입력해주세요")},
                    minLines = 5,
                    trailingIcon = {
                        if(cntVis){
                            IconButton(
                                onClick = {
                                    cntTxt = ""
                                    cntVis = false
                                }
                            ) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = "clear")
                            }
                        }
                    }
                )
                Button(
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .fillMaxWidth(1f),
                    onClick = {
                        callBack()
                    },
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = "게시글 등록하기"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddPreview(modifier: Modifier = Modifier){
    UrannyStudioTheme {
        Add(callBack = {})
    }
}
