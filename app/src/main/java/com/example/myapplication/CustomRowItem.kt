package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.models.PersonModel
import com.example.myapplication.repository.PersonRepo

@Composable
fun CustomRowItem(person: PersonModel){
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(color = Color.Gray)
            .padding(all = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Text(
            text = "${person.age}",
            color = Color.Green,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
        )
        Text(
            text = person.firstName,
            color = Color.Blue,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = MaterialTheme.typography.headlineSmall.fontWeight
        )
        Text(
            text = person.lastName,
            color = Color.DarkGray,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight
        )
    }
}


@Composable
@Preview
fun PreviewRow(){
    CustomRowItem(person = PersonRepo().getPersons().first())
}
