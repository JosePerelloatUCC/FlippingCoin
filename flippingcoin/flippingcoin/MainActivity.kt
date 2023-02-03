package com.example.flippingcoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.flippingcoin.ui.theme.FlippingCoinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlippingCoinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var roll by remember { mutableStateOf(1) }
    Column() {
        when(roll) {
            1 -> { Image(painter = painterResource(id = R.drawable.tails_d1), contentDescription = stringResource(
                id = R.string.tails_desc
            ))
                Text(text = "You got Tails")
             }
            2 -> {
                Image(painter = painterResource(id = R.drawable.heads_d2), contentDescription = stringResource(id = R.string.heads_tails_desc))
                Text(text = "You got Heads")
            }
        }
        /*Text(text = "Hello $name!")*/

        Button(onClick = { roll = (1..2).random() }) {
            Text("Roll")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FlippingCoinTheme {
        Greeting("Android")
    }
}