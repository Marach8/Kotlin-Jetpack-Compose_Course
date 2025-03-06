package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (
                        modifier = Modifier.padding(innerPadding).fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        Greeting(
//                            name = "Hello Android, this is my first android project",
//                            modifier = Modifier.padding(innerPadding)
//                        )
//                        ExpandableText()
                        LoadCoilImage()
                    }

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier){
    Text(
        text = name,
        modifier = modifier
    )
}



@Preview(showBackground = true, name = "Emmanuel")
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        ExpandableText()
    }
}



@Composable
fun LoadCoilImage(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = "https://fastly.picsum.photos/id/834/200/300.jpg?hmac=9hu4aro5r8PEFwzVlhizygx4urxyeGGjgyMRXUgKOsE")
                .apply(
                    block = fun ImageRequest.Builder.() {
                        //placeholder(R.drawable.google)
                    }
                ).build()
        )
        val painterState = painter.state;
        Image(
            painter = painter,
            contentDescription = "this is an image"
        )
        if(painterState is AsyncImagePainter.State.Loading){
            CircularProgressIndicator(
                color = Color.White
            )
        }
    }
}
