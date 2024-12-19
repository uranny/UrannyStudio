@file:Suppress("UNUSED_EXPRESSION")

package com.example.urannystudio.navitem

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.urannystudio.R
import com.example.urannystudio.ui.theme.UrannyStudioTheme

@Composable
fun Add(modifier: Modifier = Modifier, callBack: () -> Unit){

    val context = LocalContext.current

    var imgUri by remember{ mutableStateOf<Uri?>(null) }

    var ttlTxt by remember { mutableStateOf("") }
    var ttlVis by remember { mutableStateOf(false) }

    var cntTxt by remember { mutableStateOf("") }
    var cntVis by remember { mutableStateOf(false) }
    val imgLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            imgUri = it
        }
    )

    Box(modifier = modifier.fillMaxSize()){
        Surface(modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
        ) {
            val scrollState = rememberScrollState()
            Column(modifier = Modifier
                .verticalScroll(scrollState)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imgUri)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .build(),
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(350.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .clickable {
                            val request = PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            imgLauncher.launch(request)
                            Toast.makeText(context, "사진 추가", Toast.LENGTH_SHORT).show()
                        },
                    contentDescription = "",
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
                        text = "게시글 등록하기",
                        color = Color.White
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
