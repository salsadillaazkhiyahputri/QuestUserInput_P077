package com.example.formpendaftaran

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = Modifier.padding(top = 50.dp),
        title = {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontSize = 26.sp,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF9CCC65) // hijau mint pastel lembut
        )
    )
}

@Composable
fun FormPendaftaran(modifier: Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val statusKawin = listOf("Janda", "Lajang", "Duda")

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF1F8E9))
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White), // card putih bersih
            modifier = Modifier
                .padding(horizontal = 25.dp, vertical = 15.dp)
                .width(500.dp)
                .height(675.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    stringResource(R.string.nama).uppercase(),
                    color = Color(0xFF33691E),
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.padding(5.dp)
                )
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    label = { Text(text = "Isian Nama Lengkap", color = Color.Gray) },
                    onValueChange = { newText -> textNama = newText },
                    colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black,
                            cursorColor = Color.Black
                        )
                    )
                Text(
                    stringResource(R.string.jenis).uppercase(),
                    color = Color(0xFF33691E),
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.padding(5.dp)
                )
                Column(modifier = Modifier.padding(5.dp)) {
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = { textJK = item },
                                colors = androidx.compose.material3.RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFF81C784)
                                )
                            )
                            Text(item, color = Color.Black, fontFamily = FontFamily.Monospace)
                        }
                    }
                }
                Text(
                    stringResource(R.string.status).uppercase(),
                    color = Color(0xFF33691E),
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.padding(5.dp)
                )
                Column(modifier = Modifier.padding(5.dp)) {
                    statusKawin.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textStatus == item,
                                onClick = { textStatus = item },
                                colors = androidx.compose.material3.RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFF81C784)
                                )
                            )
                            Text(item, color = Color.Black, fontFamily = FontFamily.Monospace)
                        }
                    }
                }
                Text(
                    stringResource(R.string.alamat).uppercase(),
                    color = Color(0xFF33691E),
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.padding(5.dp)
                )
                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    label = { Text(text = "Alamat", color = Color.Gray) },
                    onValueChange = { newText -> textAlamat = newText },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black
                    )
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF81C784),
                        contentColor = Color.White
                    ),
                    enabled = textAlamat.isNotEmpty() &&
                            textNama.isNotEmpty() &&
                            textJK.isNotEmpty() &&
                            textStatus.isNotEmpty(),
                    onClick = {
                        nama = textNama
                        jenis = textJK
                        status = textStatus
                        alamat = textAlamat
                    }
                ) {
                    Text(
                        stringResource(R.string.submit),
                        fontFamily = FontFamily.Monospace
                    )
                }
            }
        }
    }
}










