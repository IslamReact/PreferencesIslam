package com.islamelmrabet.preferencesislam.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.islamelmrabet.preferencesislam.Data.User
import com.islamelmrabet.preferencesislam.R
import com.islamelmrabet.preferencesislam.viewmodel.PreferencesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController, preferencesViewModel: PreferencesViewModel) {
    val userName by preferencesViewModel.name.observeAsState("")
    val userPhone by preferencesViewModel.numberPhone.observeAsState(0)

    LaunchedEffect(Unit) {
        preferencesViewModel.loadUser()
    }

    Scaffold(
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .padding(it),
                ) {
                    Text("Nombre: $userName")
                    Text("Telfono: $userPhone")
                }
            },
            bottomBar = {
                BottomAppBar (
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .height(90.dp)
                ){
                    AboutMe(
                        image = painterResource(id = R.drawable.fotoperfil),
                        name = "Islam"
                    )
                    Spacer(modifier = Modifier.width(70.dp))
                    Button(
                        onClick = {
                            navController.popBackStack()
                            preferencesViewModel.saveUser("",0)
                            preferencesViewModel.onUserPhoneChanged(0)
                            preferencesViewModel.onUserNameChanged("")
                        },
                        content = {
                            Text(text = "Cerrar sesion")
                        }
                    )

                }
            }
        )
    }

//Composable que recibe de parametro una imagen y un nombre para crear la cabecera
@Composable
fun AboutMe(image: Painter, name: String) {
    Row(
        modifier = Modifier
            .padding(start = 25.dp)
    ) {
        Image(
            painter = image, contentDescription = "Foto de $name",
            modifier = Modifier
                .width(60.dp)
                .clip(CircleShape)
                .border(
                    width = 5.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = name,
            fontSize = 15.sp,
            modifier = Modifier
                .paddingFromBaseline(35.dp)
        )
    }
}