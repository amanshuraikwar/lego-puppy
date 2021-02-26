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
