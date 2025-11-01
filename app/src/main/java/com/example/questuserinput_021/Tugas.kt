package com.example.questuserinput_021

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormTugas(modifier: Modifier){
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJkel by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var status1 by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-Laki", "Perempuan")
    val status: List<String> = listOf("Belum Kawin", "Kawin", "Janda","Duda")
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 1f,
        )
        Column(modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Form Registrasi", modifier = Modifier.padding(5.dp),
//                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    textAlign = TextAlign.End
                )
            }
            OutlinedTextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = "Nama Lengkap")},
                modifier = Modifier.padding(10.dp)
                    .fillMaxWidth(1f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.DarkGray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray,
                )
            )
            ElevatedCard(modifier = Modifier
                .fillMaxWidth(1f)
                .padding(all = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 50.dp)
            ) {
                Text(text = "Status Perkahwinan",modifier = Modifier.padding(all = 10.dp), fontWeight = FontWeight.Bold)
                Column() {
                    status.forEach { item ->
                        Column(
                            modifier = Modifier
                                .selectable(
                                    selected = textStatus == item,
                                    onClick = {textStatus == item}
                                )
                        )
                        {
                            Row() {
                                RadioButton(
                                    selected = textStatus == item,
                                    onClick = {textStatus = item}
                                )
                                Text(
                                    text = item,
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                            }

                        }
                    }
                }
            }
            ElevatedCard(modifier = Modifier
                .fillMaxWidth(1f)
                .padding(all = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 50.dp)
            ) {
                Text(text = "Status Perkahwinan",modifier = Modifier.padding(all = 10.dp), fontWeight = FontWeight.Bold)
                Column() {
                    gender.forEach { item ->
                        Column(
                            modifier = Modifier
                                .selectable(
                                    selected = textJkel == item,
                                    onClick = {textJkel == item}
                                )
                        )
                        {
                            Row() {
                                RadioButton(
                                    selected = textJkel == item,
                                    onClick = {textJkel = item}
                                )
                                Text(
                                    text = item,
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                            }

                        }
                    }
                }
            }
            OutlinedTextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = "Alamat Lengkap")},
                modifier = Modifier.padding(10.dp)
                    .fillMaxWidth(1f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.DarkGray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray,
                )
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 1f)
                    .padding(all = 10.dp),
//                enabled = textAlamat.isNotEmpty(),
                onClick = {
                    jk = textJkel
                    status1 = textStatus
                }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }

        }
    }

}