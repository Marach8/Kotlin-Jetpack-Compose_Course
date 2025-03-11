package com.example.myapplication.repository

import com.example.myapplication.models.PersonModel

class PersonRepo {
    fun getPersons(): List<PersonModel>{
        return listOf(
            PersonModel(
                id = 1,
                firstName = "Emma",
                lastName = "Boss",
                age = 20
            ),
            PersonModel(
                id = 2,
                firstName = "Emmanuel",
                lastName = "Okon",
                age = 30
            ),
            PersonModel(
                id = 3,
                firstName = "David",
                lastName = "Lukas",
                age = 40
            ),
            PersonModel(
                id = 4,
                firstName = "Boss Man",
                lastName = "Wan",
                age = 45
            ),
            PersonModel(
                id = 5,
                firstName = "Bishop",
                lastName = "Mesken",
                age = 60
            ),
            PersonModel(
                id = 6,
                firstName = "Manage",
                lastName = "Me",
                age = 36
            ),
            PersonModel(
                id = 7,
                firstName = "Nkechi",
                lastName = "Chin",
                age = 24
            ),
            PersonModel(
                id = 8,
                firstName = "Obaje",
                lastName = "Chikas",
                age = 12
            ),
            PersonModel(
                id = 9,
                firstName = "Sampson",
                lastName = "Okoro",
                age = 87
            ),
            PersonModel(
                id = 10,
                firstName = "Boy",
                lastName = "Man",
                age = 68
            ),
            PersonModel(
                id = 8,
                firstName = "Obaje",
                lastName = "Chikas",
                age = 12
            ),
            PersonModel(
                id = 9,
                firstName = "Sampson",
                lastName = "Okoro",
                age = 87
            ),
        )
    }
}