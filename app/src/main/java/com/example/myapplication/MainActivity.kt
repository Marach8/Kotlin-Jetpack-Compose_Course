package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Greeting(
                            name = "Android, this is my first",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }

                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.background(Color.Green)
            .width(500.dp)
            .height(500.dp),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier.background(Color.Blue)

        ){
            Text(
                text = "The box is equivalent to the stack in flutter",
                fontSize = 40.sp
            )
        }
    }
}


@Composable
fun RowScope.CustomItem(weight: Float, color: Color){
    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
            .weight(weight),
        color = color
    ) { }
}


@Preview(showBackground = true, name = "Emmanuel")
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting(name = "")
//        Row(
//            modifier = Modifier.fillMaxSize(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            CustomItem(weight = 3f, color = MaterialTheme.colorScheme.primary)
//            CustomItem(weight = 2f, color = MaterialTheme.colorScheme.secondary)
//        }
    }
}


//@Composable
//fun CustomText(text: String){
//    Text(
//        text = text,
//    )
//}