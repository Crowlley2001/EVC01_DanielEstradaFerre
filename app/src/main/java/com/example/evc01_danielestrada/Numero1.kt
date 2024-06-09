package com.example.evc01_danielestrada

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun PrecioCliente() {
    var cantidad by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var costoTotal by remember { mutableStateOf(0.0) }
    var costoDescuento by remember { mutableStateOf(0.0) }

    fun calcularTotal() {
        val cantidadInt = cantidad.toIntOrNull() ?: 0
        val precioDouble = precio.toDoubleOrNull() ?: 0.0
        costoTotal = cantidadInt * precioDouble
        costoDescuento = if (costoTotal > 200) costoTotal * 0.8 else costoTotal
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de Descuentos",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio Unitario") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(onClick = { calcularTotal() }) {
            Text(text = "Calcular Total")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Total: $${costoTotal.roundToInt()}", fontSize = 20.sp)
        Text(text = "Total con Descuento: $${costoDescuento.roundToInt()}", fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun CalcularDescuentoPreview() {
    PrecioCliente()
}