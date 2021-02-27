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
package com.example.androiddevchallenge.ui.puppies

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.actionbar.PuppyActionBar
import com.example.androiddevchallenge.util.PreviewSurface
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Composable
fun Puppies(
    onPuppyClicked: (Puppy) -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val lock = Mutex(false)

    val puppyList = remember {
        List(100) {
            Puppy()
        }
    }

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxHeight()
    ) {
        LazyColumn(
            contentPadding = LocalWindowInsets.current.systemBars.toPaddingValues()
        ) {
            item {
                var visible by remember { mutableStateOf(false) }
                val progress by animateFloatAsState(if (visible) 1f else 0f)

                scope.launch {
                    delay(300)
                    visible = true
                }

                PuppyActionBar(
                    Modifier
                        .fillMaxWidth()
                        .alpha(progress)
                        .absoluteOffset(x = (-40 * (1f - progress)).dp)
                )
            }

            items(puppyList) { item ->
                var visible by remember { mutableStateOf(false) }
                val alpha by animateFloatAsState(if (visible) 1f else 0f)

                scope.launch {
                    delay(300)
                    visible = true
                }

                PuppyItem(
                    Modifier
                        .clickable(
                            onClick = {
                                scope.launch {
                                    if (lock.isLocked) return@launch
                                    lock.withLock {
                                        delay(100)
                                        onPuppyClicked(item)
                                    }
                                }
                            }
                        )
                        .fillMaxWidth()
                        .alpha(alpha),
                    puppy = item
                )
            }
        }
    }
}

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Preview
@Composable
fun PuppiesPreview() {
    PreviewSurface {
        Puppies()
    }
}

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Preview
@Composable
fun PuppiesPreviewDark() {
    PreviewSurface(darkTheme = true) {
        Puppies()
    }
}
