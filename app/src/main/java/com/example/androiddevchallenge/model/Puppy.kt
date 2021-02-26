package com.example.androiddevchallenge.model

import androidx.annotation.IntRange

data class Puppy(
    val name: String,
    val breed: String,
    val imageUrl: String,
    @IntRange(from = 1, to = 30) val age: Int,
    val gender: Gender,
    val kmsAway: Int
) {

    enum class Gender {
        Male, Female
    }

    companion object {
        operator fun invoke() = Puppy(
            name = "Mr. Peabody",
            breed = "Golder Retriever",
            imageUrl = "https://images.unsplash.com/photo-1561438774-1790fe271b8f?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=joe-caione-KVeogBZzl4M-unsplash.jpg&w=640",
            age = 3,
            gender = Gender.Male,
            kmsAway = 4
        )
    }
}