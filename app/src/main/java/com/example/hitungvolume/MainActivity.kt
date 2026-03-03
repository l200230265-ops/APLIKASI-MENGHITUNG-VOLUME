package com.example.hitungvolume

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hitungvolume.ui.theme.HitungVolumeTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HitungVolumeTheme {
                VolumeApp()
            }
        }
    }
}

@Composable
fun VolumeApp() {

    var sisi by remember { mutableStateOf("") }
    var hasilKubus by remember { mutableStateOf("") }

    var jariTabung by remember { mutableStateOf("") }
    var tinggiTabung by remember { mutableStateOf("") }
    var hasilTabung by remember { mutableStateOf("") }

    var jarijari by remember { mutableStateOf("") }
    var hasilBola by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA2CB8B))
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                text = "📐 Hitung Volume",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

            FancyCard(
                title = "Kubus",
                color = Color(0xFFE8F5BD),
                result = hasilKubus,
                onClick = {
                    val s = sisi.toDoubleOrNull()
                    hasilKubus  = if (s != null && s > 0) {
                        "Volume = %.2f".format(s * s * s)
                    } else {
                        "Masukkan angka lebih dari 0"
                    }
                }
            ) {
                OutlinedTextField(
                    value = sisi,
                    onValueChange = { sisi = it },
                    label = { Text("Sisi") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFC7EABB),
                        unfocusedContainerColor = Color(0xFFC7EABB),
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            FancyCard(
                title = "Tabung",
                color = Color(0xFFE8F5BD),
                result = hasilTabung,
                onClick = {
                    val r = jariTabung.toDoubleOrNull()
                    val t = tinggiTabung.toDoubleOrNull()
                    hasilTabung = if (r != null && t != null && r > 0 && t > 0) {
                        "Volume = %.2f".format(3.14 * r * r * t)
                    } else {
                        "Masukkan angka lebih dari 0"
                    }
                }
            ) {
                OutlinedTextField(
                    value = jariTabung,
                    onValueChange = { jariTabung = it },
                    label = { Text("Jari-jari") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFC7EABB),
                        unfocusedContainerColor = Color(0xFFC7EABB),
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = tinggiTabung,
                    onValueChange = { tinggiTabung = it },
                    label = { Text("Tinggi") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFC7EABB),
                        unfocusedContainerColor = Color(0xFFC7EABB),
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            FancyCard(
                title = "Bola",
                color = Color(0xFFE8F5BD),
                result = hasilBola,
                onClick = {
                    val r = jarijari.toDoubleOrNull()
                    hasilBola = if (r != null && r > 0) {
                        val volume = (4.0 / 3.0) * Math.PI * r * r * r
                        "Volume = %.2f".format(volume)
                    } else {
                        "Masukkan angka lebih dari 0"
                    }
                }
            ) {
                OutlinedTextField(
                    value = jarijari,
                    onValueChange = { jarijari = it },
                    label = { Text("Jari-jari") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFC7EABB),
                        unfocusedContainerColor = Color(0xFFC7EABB),
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun FancyCard(
    title: String,
    color: Color,
    result: String,
    onClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            content()

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Hitung")
            }

            Spacer(modifier = Modifier.height(12.dp))

            if (result.isNotEmpty()) {
                Text(
                    text = result,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}