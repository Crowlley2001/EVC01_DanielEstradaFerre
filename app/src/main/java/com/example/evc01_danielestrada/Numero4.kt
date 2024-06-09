package com.example.evc01_danielestrada
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.evc01_danielestrada.ui.theme.EVC01_DanielEstradaTheme
@Composable
fun Calcular() {
    var limite by rememberSaveable { mutableStateOf("") }
    var resultado by rememberSaveable { mutableStateOf<List<String>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Calculadora de Potencias",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = limite,
            onValueChange = { limite = it },
            label = { Text("Ingrese el límite de número") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        Button(onClick = { resultado = calcularPotencias(limite.toIntOrNull() ?: 0) }) {
            Text(text = "Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))
        resultado.forEach { result ->
            Text(text = result, fontSize = 20.sp)
        }
    }
}

fun calcularPotencias(limite: Int): List<String> {
    val results = mutableListOf<String>()
    for (numero in 1..limite) {
        val cubo = numero * numero * numero
        val cuarta = numero * numero * numero * numero
        results.add("Número: $numero, Cubo: $cubo, Cuarta: $cuarta")
    }
    return results
}