package com.example.privacypref_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.privacypref_android.ui.theme.PrivacyPref_AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrivacyPref_AndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
     Column(
         horizontalAlignment = Alignment.Start,
         verticalArrangement = Arrangement.Center,
         modifier = modifier
     ){
    Text(
        text = "Hello $name!",
        fontSize = 30.sp,
        color = Color(255, 0, 255),
    )
         Text(
             text = "JOOOOO",
             fontSize = 25.sp,
         )
     }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrivacyPref_AndroidTheme {
        Greeting("Android")
    }
}