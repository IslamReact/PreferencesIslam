package com.islamelmrabet.preferencesislam.ui.screens.onBoarding

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.islamelmrabet.preferencesislam.Data.User
import com.islamelmrabet.preferencesislam.R
import com.islamelmrabet.preferencesislam.navigation.Routes
import com.islamelmrabet.preferencesislam.viewmodel.PreferencesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen(navController: NavHostController, preferencesViewModel: PreferencesViewModel) {
    val userData by preferencesViewModel.user.observeAsState()

    // Cargar datos del usuario al inicializar la pantalla
    LaunchedEffect(Unit) {
        preferencesViewModel.loadUser()
    }

    var userName by remember { mutableStateOf("") }
    var userPhone by remember { mutableStateOf("") }
    var isButtonEnabled = userName.isNotBlank() && userPhone.isNotBlank()


    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.inversePrimary)
                    .padding(it),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Bienvenido!",
                        modifier = Modifier
                            .absoluteOffset(x = 10.dp),
                        fontSize = 25.sp,
                        color = MaterialTheme.colorScheme.surface,
                        style = MaterialTheme.typography.headlineLarge,
                    )
                }
                // Campo para introducir el nombre
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                ) {
                    OutlinedTextField(
                        value = userName,
                        onValueChange = { userName = it },
                        label = {
                            Text(text = "Introduce tu nombre")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = userPhone,
                        onValueChange = { userPhone = it },
                        label = {
                            Text(
                                text = "Introduce tu teléfono",
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        },
        bottomBar = {
            // Foto tipo carnet y nombre
            Divider()
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AboutMe(
                    image = painterResource(id = R.drawable.fotoperfil),
                    name = "Islam"
                )
                Spacer(modifier = Modifier.width(90.dp))
                // Boton para navegar a la siguiente ventana
                Button(
                    onClick = {
                        if (isButtonEnabled) {
                            navController.navigate("main_screen")
                            preferencesViewModel.saveUser(userName, userPhone.toIntOrNull() ?: 0)
                        }
                    },
                    enabled = isButtonEnabled,
                ) {
                    Text(
                        text = "Siguiente",
                    )
                }
            }
        }
    )
}
//Composable que recibe de parametro una imagen y un nombre para crear la cabecera
@Composable
fun AboutMe(image: Painter, name: String) {
    Row(
        modifier = Modifier
            .padding(15.dp)
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
        Spacer(modifier = Modifier.width(25.dp))
        Text(
            text = name,
            fontSize = 15.sp,
            modifier = Modifier
                .paddingFromBaseline(35.dp)
        )
    }
}