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
package com.example.androiddevchallenge

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.util.Navigator
import kotlinx.parcelize.Parcelize

/**
 * Models the screens in the app and any arguments they require.
 */
sealed class Destination : Parcelable {
    @Parcelize
    object Puppies : Destination()

    @Immutable
    @Parcelize
    data class PuppyDetail(val puppy: Puppy) : Destination()
}

/**
 * Models the navigation actions in the app.
 */
class Actions(navigator: Navigator<Destination>) {
    val selectPuppy: (Puppy) -> Unit = { puppy: Puppy ->
        navigator.navigate(Destination.PuppyDetail(puppy))
    }
    val upPress: () -> Unit = {
        navigator.back()
    }
}
