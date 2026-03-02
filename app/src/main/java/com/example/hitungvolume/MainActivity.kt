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

    var jariKerucut by remember { mutableStateOf("") }
    var tinggiKerucut by remember { mutableStateOf("") }
    var hasilKerucut by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFfaedcd))
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
                color = Color(0xFFccd5ae),
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
                        focusedContainerColor = Color(0xFFfefae0),
                        unfocusedContainerColor = Color(0xFFfefae0),
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            FancyCard(
                title = "Tabung",
                color = Color(0xFFccd5ae),
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
                        focusedContainerColor = Color(0xFFfefae0),
                        unfocusedContainerColor = Color(0xFFfefae0),
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
                        focusedContainerColor = Color(0xFFfefae0),
                        unfocusedContainerColor = Color(0xFFfefae0),
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            FancyCard(
                title = "Kerucut",
                color = Color(0xFFccd5ae),
                result = hasilKerucut,
                onClick = {
                    val r = jariKerucut.toDoubleOrNull()
                    val t = tinggiKerucut.toDoubleOrNull()
                    hasilKerucut = if (r != null && t != null && r > 0 && t > 0) {
                        "Volume = %.2f".format((1.0 / 3.0) * 3.14 * r * r * t)
                    } else {
                        "Masukkan angka lebih dari 0"
                    }
                }
            ) {
                OutlinedTextField(
                    value = jariKerucut,
                    onValueChange = { jariKerucut = it },
                    label = { Text("Jari-jari") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFfefae0),
                        unfocusedContainerColor = Color(0xFFfefae0),
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = tinggiKerucut,
                    onValueChange = { tinggiKerucut = it },
                    label = { Text("Tinggi") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFfefae0),
                        unfocusedContainerColor = Color(0xFFfefae0),
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