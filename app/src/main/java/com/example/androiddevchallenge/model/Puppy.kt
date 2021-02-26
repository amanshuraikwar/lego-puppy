package com.example.androiddevchallenge.model

import android.os.Parcelable
import androidx.annotation.IntRange
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    val name: String,
    val breed: String,
    val imageUrl: String,
    @IntRange(from = 1, to = 30) val age: Int,
    val gender: Gender,
    val kmsAway: Int
) : Parcelable {

    enum class Gender {
        Male, Female
    }

    companion object {
        private val imageList = listOf(
            "https://images.unsplash.com/photo-1546238232-20216dec9f72?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDF8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1519150268069-c094cfc0b3c8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDJ8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1560807707-8cc77767d783?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDN8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1525253086316-d0c936c814f8?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDR8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1610112645245-36020fc0e128?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDV8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1548199973-03cce0bbc87b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDZ8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1583336663277-620dc1996580?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDd8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1592817797597-392e3b878e1c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDh8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1548658166-136d9f6a7e76?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDl8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080"
        )

        operator fun invoke() = Puppy(
            name = "Mr. Peabody",
            breed = "Golder Retriever",
            imageUrl = imageList.random(),
            age = 3,
            gender = Gender.Male,
            kmsAway = 4
        )
    }
}