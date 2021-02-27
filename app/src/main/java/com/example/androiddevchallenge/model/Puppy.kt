/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.model

import android.os.Parcelable
import androidx.annotation.IntRange
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    val name: String,
    val breed: String,
    val puppyPhotoUrlList: List<String>,
    @IntRange(from = 1, to = 30) val age: Int,
    val gender: Gender,
    val kmsAway: Int,
    val location: String,
    val bio: String
) : Parcelable {

    enum class Gender {
        Boi, Gurl
    }

    companion object {
        private val puppyPhotos by lazy {
            fun String.url(): String {
                return "https://images.unsplash.com/$this?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDF8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080"
            }

            listOf(
                listOf(
                    "photo-1560807707-8cc77767d783".url(),
                    "photo-1593134257782-e89567b7718a".url(),
                ),
                listOf(
                    "photo-1591160690555-5debfba289f0".url(),
                    "photo-1507146426996-ef05306b995a".url(),
                    "photo-1600804340584-c7db2eacf0bf".url(),
                ),
                listOf(
                    "photo-1610621488354-c7274b9690d1".url(),
                    "photo-1577198499139-620a2f90f668".url(),
                    "photo-1589941013453-ec89f33b5e95".url(),
                    "photo-1612389648232-d506dd957ca3".url(),
                ),
                listOf(
                    "photo-1576415928601-b25522bc9e5a".url(),
                    "photo-1561754050-9a1ee0470c73".url(),
                    "photo-1586713471521-2325b2b674e4".url(),
                    "photo-1509463545580-61e747a6a12f".url(),
                ),
                listOf(
                    "photo-1575535468632-345892291673".url(),
                    "photo-1604891599626-9bc48fafb832".url(),
                    "photo-1523171067267-bb96f975c4bb".url(),
                ),
            )
        }

        private val breeds by lazy {
            listOf(
                "Cavalier King",
                "Golden Retriever",
                "German Shepherd",
                "Bull Dog",
                "Shiba Inu",
            )
        }

        private val dogNames = listOf(
            "Luna",
            "Duke",
            "Rocky",
            "Milo",
            "Jackson",
            "Maddie",
            "Buster",
            "Frankie",
            "Apollo",
        )

        operator fun invoke(): Puppy {
            val index = (0..4).random()
            val name = dogNames.random()
            val age = (1..10).random()
            val gender = if ((0..1).random() == 0) {
                Gender.Gurl
            } else {
                Gender.Boi
            }
            val pronoun = if (gender == Gender.Boi) {
                "He"
            } else {
                "She"
            }
            return Puppy(
                name = name,
                breed = breeds[index],
                puppyPhotoUrlList = puppyPhotos[index],
                age = age,
                gender = gender,
                kmsAway = (0..10).random(),
                location = "Toa Payoh",
                bio = "$name is a $age year old house trained " +
                    "$gender. $pronoun is super friendly. " +
                    "$pronoun loves people, other dogs, even cats. " +
                    "$pronoun loves playing with toys and going on walks. " +
                    "$pronoun loves to explore!"
            )
        }
    }
}
