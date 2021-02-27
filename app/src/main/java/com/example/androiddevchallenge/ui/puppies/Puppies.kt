package com.example.androiddevchallenge.ui.puppies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                PuppyActionBar(Modifier.fillMaxWidth())
            }

            items(puppyList) { item ->
                PuppyItem(
                    Modifier
                        .clickable(
                            onClick = {
                                scope.launch {
                                    if (lock.isLocked) return@launch
                                    lock.withLock {
                                        delay(300)
                                        onPuppyClicked(item)
                                    }
                                }
                            }
                        )
                        .fillMaxWidth(),
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