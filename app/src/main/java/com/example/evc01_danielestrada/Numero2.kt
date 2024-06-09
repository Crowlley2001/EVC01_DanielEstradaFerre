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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Prestamo() {
    var monto by rememberSaveable { mutableStateOf("") }
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
                text = "Calculador prestamo",
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
                value = monto,
                onValueChange = { monto = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ingrese el monto del préstamo") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = { resultado = calcularCuotas(monto.toDoubleOrNull() ?: 0.0) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

fun calcularCuotas(monto: Double): String {
    val cuotas: Int
    val interes: Double

    when {
        monto > 5000 -> cuotas = 3
        monto < 1000 -> cuotas = 1
        monto in 2000.0..3000.0 -> cuotas = 2
        else -> cuotas = 5
    }

    interes = if (monto < 4000) 0.12 else 0.10

    val montoConInteres = monto * (1 + interes)
    val valorCuota = montoConInteres / cuotas

    return "Debe pagar $cuotas cuota de $${"%.2f".format(valorCuota)} cada una Total con interés: $${"%.2f".format(montoConInteres)}"
}

@Composable
fun MySpace(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewPrestamoScreen() {
    Prestamo()
}