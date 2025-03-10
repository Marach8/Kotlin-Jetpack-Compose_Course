package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
@Preview()
fun PasswordPreview() {
    MyApplicationTheme {
        PasswordField()
    }
}


@Composable
fun TextFieldExample(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var text by remember{mutableStateOf("Enter your name...")}
        OutlinedTextField(
            value = text,
            onValueChange = {
                input -> text = input
            },
            label = {Text(text = "Title of textfield")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = { Log.d("I get","I have sent it")}
            )
        )
    }
}



@Composable
fun PasswordField(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisible by remember {mutableStateOf(false)}

        val icon = if(passwordVisible)
                Icons.Outlined.VisibilityOff
            else
                Icons.Outlined.Visibility

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            placeholder = {Text(text = "Enter password here")},
            label = {Text(text = "Password")},
            visualTransformation = if(passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(
                    onClick = {passwordVisible = !passwordVisible}
                ){
                    Icon(
                        imageVector = icon,
                        contentDescription = "My Icon",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        )
    }
}