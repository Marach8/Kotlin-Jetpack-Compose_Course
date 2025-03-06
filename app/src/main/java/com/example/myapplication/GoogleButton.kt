package com.example.myapplication


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon



@Composable
fun GoogleButton(){
    var isClicked by remember { mutableStateOf(false) }

    Surface(
        onClick = {isClicked = !isClicked},
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(width = 0.5.dp, color = Color.Green),
        color = Color.White
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                start = 12.dp, end = 16.dp,
                top = 12.dp, bottom = 12.dp
            ).animateContentSize(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutLinearInEasing
                )
            )
        ){
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "My Icon",
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                //modifier = Modifier.weight(3f),
                text = "Sign Up with Google",
                color = Color.Black
            )
            if(isClicked) {
                Spacer(modifier = Modifier.width(10.dp))
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    color = Color.Green,
                    strokeWidth = 2.dp,
                )
            }
        }
    }
}


@Composable
@Preview
fun GoogleBtnPreview(){
    GoogleButton()
}