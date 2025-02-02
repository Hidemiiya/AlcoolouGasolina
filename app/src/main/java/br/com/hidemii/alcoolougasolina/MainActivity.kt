package br.com.hidemii.alcoolougasolina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.hidemii.alcoolougasolina.ui.theme.AlcoolOuGasolinaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlcoolOuGasolinaTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}


@Composable
fun App() {
    var valorGasolina by remember {
        mutableStateOf("")
    }
    var valorAlcool by remember {
        mutableStateOf("")
    }

Box {
        Column(
            Modifier
                .background(color = Color(0xFF000000))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
              ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                  ) {
                Text(
                    text = "Álcool ou Gasolina?",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                                     )
                    )
                Text(
                    text = "É melhor abastecer com: ",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                if (valorGasolina.isNotBlank() && valorAlcool.isNotBlank())
                {
                    val gasolina = valorAlcool.toDouble() / valorGasolina.toDouble() > 0.7

                val GasolinaOuAlcool = if (gasolina) {
                    "Gasolina"
                } else {
                    "Álcool"
                }
                val cor = if(gasolina) {
                    Color.Yellow
                } else {
                    Color.Cyan
                }
                Text(
                    text = GasolinaOuAlcool,
                    style = TextStyle(color = cor, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    )
                }
                TextField(
                    value = valorGasolina,
                    onValueChange = {
                        valorGasolina = it
                                    },
                    label = { Text(
                                text = "Gasolina",
                                style = TextStyle(
                                    fontSize = 18.sp
                                                )
                                  )
                            }
                        )

                TextField(
                    value = valorAlcool,
                    onValueChange = {
                        valorAlcool = it

                    },
                    label = { Text(
                                text = "Álcool",
                                style = TextStyle(
                                    fontSize = 18.sp
                                                )
                                    )
                            }
                )
            }
                }
        }
}

@Preview
@Composable
fun AppPreview(){
    AlcoolOuGasolinaTheme {
        App()
    }
}