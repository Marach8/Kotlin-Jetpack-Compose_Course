package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
import com.example.myapplication.repository.PersonRepo
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val sections = listOf("A", "B", "C", "D", "E")
                LazyColumn (
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(all = 20.dp)
                ){
                    sections.forEach{ section ->
                        stickyHeader {
                            Text(
                                text = "section $section",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.LightGray)
                                    .padding(20.dp)
                            )
                        }
                        items(10){
                            Text(
                                text = "item $it from section $section",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                            )
                        }
                    }
                }
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Column (
//                        modifier = Modifier.padding(innerPadding).fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        val persons = PersonRepo().getPersons()
//
////                        Greeting(
////                            name = "Hello Android, this is my first android project",
////                            modifier = Modifier.padding(innerPadding)
////                        )
////                        ExpandableText()
////                        LoadCoilImage()
////                        PasswordField()
////                        GradientButton(
////                            text = "Button",
////                            textColor = Color.White,
////                            onClick = {},
////                            gradient = Brush.horizontalGradient(
////                                colors = listOf(
////                                    Color.Blue,
////                                    Color.Yellow
////                                )
////                            )
////                        )
//                    }
//
//                }
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
