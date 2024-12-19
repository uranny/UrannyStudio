package com.example.urannystudio

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.urannystudio.ui.theme.UrannyStudioTheme

@Composable
fun LogIn(modifier: Modifier = Modifier, navController: NavController){

    var inputId by remember { mutableStateOf("") }
    var idBool by remember { mutableStateOf(false) }
    var inputPass by remember { mutableStateOf("") }
    var passBool by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier.fillMaxSize(1f)
    ) {
        Box(modifier = Modifier) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .align(Alignment.Center)
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(200.dp)
                        .height(200.dp)
                        .padding(bottom = 12.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo"
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(vertical = 6.dp, horizontal = 24.dp),
                    value = inputId,
                    onValueChange = {
                        inputId = it
                        idBool = inputId.isNotBlank()
                    },
                    label = {
                        Text(text = "아이디를 입력해주세요" )},
                    maxLines = 1,
                    trailingIcon = {
                        if(idBool){
                            IconButton(
                                onClick = {
                                    inputId = ""
                                    idBool = false
                                }
                            ){
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "clearBtn"
                                )
                            }
                        }
                    }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(bottom = 6.dp, start = 24.dp, end = 24.dp),
                    value = inputPass,
                    onValueChange = {
                        inputPass = it
                        passBool = inputPass.isNotBlank()
                    },
                    label = { Text(text = "비밀번호를 입력해주세요" )},
                    maxLines = 1,
                    trailingIcon = {
                        if(passBool){
                            IconButton(
                                onClick = {
                                    inputPass = ""
                                    passBool = false
                                }
                            ){
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "clearBtn"
                                )
                            }
                        }
                    }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(horizontal = 24.dp, vertical = 12.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Black,
                        disabledContentColor = Color.Black,
                        disabledContainerColor = Color.Black
                    ),
                    shape = RoundedCornerShape(5.dp),
                    onClick = {
                        navController.navigate("Main")
                    }
                ) {
                    Text(
                        modifier = Modifier
                            .padding(all = 6.dp),
                        color = Color.White,
                        text = "로그인하기"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLogIn(modifier: Modifier = Modifier){
    UrannyStudioTheme {
        val context = LocalContext.current
        LogIn(navController = NavController(context))
    }
}