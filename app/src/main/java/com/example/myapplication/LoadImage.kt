package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

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