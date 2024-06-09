package com.example.appbasiccomponent

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VocalScreen() {
    var numero by rememberSaveable { mutableStateOf("") }
    var resultado by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Conversor de Número a Vocal",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            )
            OutlinedTextField(
                value = numero,
                onValueChange = { numero = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ingrese un número del 1 al 5") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = { resultado = numeroAVocal(numero.toIntOrNull() ?: 0) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Convertir")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

fun numeroAVocal(numero: Int): String {
    return when (numero) {
        1 -> "La vocal correspondiente es A."
        2 -> "La vocal correspondiente es E."
        3 -> "La vocal correspondiente es I."
        4 -> "La vocal correspondiente es O."
        5 -> "La vocal correspondiente es U."
        else -> "Por favor, ingrese un número válido del 1 al 5."
    }
}

