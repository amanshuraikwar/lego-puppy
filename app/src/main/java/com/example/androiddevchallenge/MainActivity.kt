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

import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.puppies.Puppies
import com.example.androiddevchallenge.ui.puppydetail.PuppyDetail
import com.example.androiddevchallenge.ui.theme.LegoPuppyTheme
import com.example.androiddevchallenge.util.Navigator
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    @ExperimentalStdlibApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MyApp(onBackPressedDispatcher)
        }
    }
}

// Start building your app here!
@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Composable
fun MyApp(backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSaveable(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Puppies, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }
    val puppyList = remember {
        List(100) {
            Puppy()
        }
    }
    ProvideWindowInsets(consumeWindowInsets = false) {
        LegoPuppyTheme {
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    Destination.Puppies -> Puppies(
                        puppyList = puppyList,
                        onPuppyClicked = actions.selectPuppy
                    )
                    is Destination.PuppyDetail -> PuppyDetail(
                        puppy = destination.puppy,
                        upPress = actions.upPress
                    )
                }
            }
        }
    }
}

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
//    LegoPuppyTheme {
//        MyApp()
//    }
}

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
//    LegoPuppyTheme(darkTheme = true) {
//        MyApp()
//    }
}
