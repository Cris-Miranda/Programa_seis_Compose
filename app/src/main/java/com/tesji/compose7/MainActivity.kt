package com.tesji.compose7
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login()
        }
    }
}
@Composable
fun Login() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        var usuario by remember { mutableStateOf("") }
        var clave by remember { mutableStateOf("") }
        var resultado by remember {mutableStateOf("Sin resultado")}
        OutlinedTextField (
            value = usuario,
            onValueChange = { usuario = it },
            label = {
                Text("Nombre de usuario")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )
        OutlinedTextField (
            value = clave,
            onValueChange = { clave = it },
            label = {
                Text("Clave")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {
                var cadena = ""
                if (clave.length < 10)
                    cadena += "La clave debe tener al menos 10 caracteres\n"
                if (usuario.length == 0)
                    cadena += "No puede dejar el usuario vacio"
                resultado = cadena
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Confirmar")
        }
        Text(
            text = resultado,
            modifier = Modifier.padding(10.dp)
        )
    }
}
