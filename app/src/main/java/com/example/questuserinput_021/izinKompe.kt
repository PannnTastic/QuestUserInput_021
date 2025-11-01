package com.example.questuserinput_021

import android.app.AlertDialog
import android.icu.util.Calendar
import android.widget.NumberPicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormRegistrasi(modifier: Modifier)
{
    var txtNama by remember { mutableStateOf("") }
    var txtAsal by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = it
        "${calendar.get(Calendar.DAY_OF_MONTH)}/${calendar.get(Calendar.MONTH) + 1}/${calendar.get(Calendar.YEAR)}"
    } ?: ""

    var txtRw by remember { mutableStateOf("") }
    var txtRt by remember { mutableStateOf("") }
    var intUmur by remember { mutableIntStateOf(0)  }
    var showNumberPicker by remember { mutableStateOf(false) }
    var txtJk by remember { mutableStateOf("") }
    var check by remember { mutableStateOf(false) }


    var nama by remember { mutableStateOf("") }
    var asal by remember { mutableStateOf("") }
    var rt by remember { mutableStateOf("") }
    var rw by remember { mutableStateOf("") }
    var umur by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }
    var tgl by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }


    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Bacground Image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier
            .padding(top = 70.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(all = 20.dp)
                    .alpha(0.93f),
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 50.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(all = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    OutlinedTextField(
                        value = txtNama,
                        singleLine = true,
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier
//                            .width(width = 250.dp)
                            .fillMaxWidth(1f)
                            .padding(bottom = 15.dp, start = 20.dp, end = 20.dp, top = 40.dp),
                        label = { Text(text = stringResource(id = R.string.nama)) },
                        onValueChange = {
                            txtNama = it
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorResource(id = R.color.placeholder),
                            unfocusedBorderColor = Color.Gray,
                            unfocusedLabelColor = Color.Gray
                        )
                    )
                    OutlinedTextField(
                        value = txtAsal,
                        singleLine = true,
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier
//                            .width(width = 250.dp)
                            .fillMaxWidth(1f)
                            .padding(bottom = 15.dp, start = 20.dp, end = 20.dp),
                        label = { Text(text = stringResource(id = R.string.asal)) },
                        onValueChange = {
                            txtAsal = it
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorResource(id = R.color.placeholder),
                            unfocusedBorderColor = Color.Gray,
                            unfocusedLabelColor = Color.Gray
                        )
                    )
                    Row(
                        modifier = Modifier
//                            .fillMaxWidth()
                            .padding(bottom = 15.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedTextField(
                            value = selectedDate,
                            singleLine = true,
                            shape = MaterialTheme.shapes.large,
                            onValueChange = { },
                            readOnly = true,
                            label = {
                                Text(stringResource(id = R.string.tgl_lahir))
                            },
                            trailingIcon = {
                                IconButton(
                                    onClick = { showDatePicker = !showDatePicker }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = "Select Date"
                                    )
                                }
                            },
                            modifier = Modifier.weight(1f)
                                .clickable(enabled = true,onClick = { showDatePicker = true }),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.placeholder),
                                unfocusedBorderColor = Color.Gray,
                                unfocusedLabelColor = Color.Gray
                            )
                        )
                        OutlinedTextField(
                            value = txtRt,
                            singleLine = true,
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier
                                .width(width = 60.dp),
//                                .padding(top = 7.dp),
                            onValueChange = {
                                txtRt = it
                            },
                            label = {
                                Text(stringResource(id = R.string.rt))
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.placeholder),
                                unfocusedBorderColor = Color.Gray,
                                unfocusedLabelColor = Color.Gray
                            )
                        )
                        VerticalDivider(
                            thickness = dimensionResource(id = R.dimen.thin_divider),
                            modifier = Modifier.padding(top = 16.dp, bottom = 10.dp).height(height = 40.dp)

                        )
                        OutlinedTextField(
                            value = txtRw,
                            singleLine = true,
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier
                                .width(width = 60.dp),
//                                .padding(top = 7.dp),
                            onValueChange = {
                                txtRw = it
                            },
                            label = {
                                Text(stringResource(id = R.string.rw))
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.placeholder),
                                unfocusedBorderColor = Color.Gray,
                                unfocusedLabelColor = Color.Gray
                            )

                        )
                    }

                    OutlinedTextField(
                        placeholder = {
                            Text("0")
                        },
                        readOnly = true,
                        value = if (intUmur > 0) intUmur.toString() else "",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier
//                            .width(width = 250.dp)
                            .fillMaxWidth(1f)
                            .padding(bottom = 15.dp, start = 20.dp, end = 20.dp)
                            .clickable(onClick = {showNumberPicker = !showNumberPicker}, enabled = showNumberPicker),
                        label = { Text(text = stringResource(id = R.string.umur)) },
                        onValueChange = {
                            intUmur = it.toIntOrNull() ?: 0
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(android.R.drawable.ic_menu_add),
                                contentDescription = "Select Number",
                                modifier = Modifier.clickable { showNumberPicker = true }
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorResource(id = R.color.placeholder),
                            unfocusedBorderColor = Color.Gray,
                            unfocusedLabelColor = Color.Gray
                        )
                    )
                    Text(stringResource(R.string.jk),
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 30.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Row {
                        gender.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .selectable(
                                        selected = txtJk == item,
                                        onClick = { txtJk = item }
                                    ), verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = txtJk == item,
                                    onClick = { txtJk = item }
                                )
                                Text(text = item)
                            }
                        }
                    }
                    Row(modifier = Modifier.padding(start = 60.dp, end = 40.dp)) {
                        Checkbox(checked = check, onCheckedChange = { check = it })
                        Text(stringResource(R.string.check),
                            fontSize = 15.sp,
                            color = Color.Gray
                        )
                    }
                    Spacer(Modifier.height(height = 50.dp))
                    Button(enabled = check,
                        onClick = {
                            nama = txtNama
                            asal = txtAsal
                            rt = txtRt
                            rw = txtRw
                            umur = intUmur.toString()
                            jk = txtJk
                            tgl = selectedDate
                            submitted = !submitted

                        },
                        modifier = Modifier.width(width = 150.dp).height(50.dp)) {
                        Text(stringResource(R.string.submit))
                    }
                    Spacer(Modifier.height(height = 50.dp))

        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(
                    state = datePickerState,
                    showModeToggle = false
                )
            }
        }
    }
}