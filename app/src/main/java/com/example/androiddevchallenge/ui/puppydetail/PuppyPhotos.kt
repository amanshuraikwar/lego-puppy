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
package com.example.androiddevchallenge.ui.puppydetail

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.util.PreviewSurface
import com.example.androiddevchallenge.util.photoSelected
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PuppyPhotos(
    modifier: Modifier = Modifier,
    photoList: List<String>
) {
    val scope = rememberCoroutineScope()
    var selectedImageIndex by remember { mutableStateOf(0) }

    Box(
        modifier,
        contentAlignment = Alignment.BottomStart
    ) {
        CoilImage(
            data = photoList[selectedImageIndex],
            contentDescription = null,
            fadeIn = true,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(MaterialTheme.colors.background)
        )

        LazyRow(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colors.background
                        )
                    )
                )
        ) {
            itemsIndexed(photoList) { index, item ->
                if (index > 0) {
                    Spacer(modifier = Modifier.size(16.dp))
                }

                var visible by remember { mutableStateOf(false) }
                val progress by animateFloatAsState(if (visible) 1f else 0f)

                scope.launch {
                    delay(index * 200L)
                    visible = true
                }

                CoilImage(
                    data = item,
                    contentDescription = null,
                    fadeIn = true,
                    contentScale = ContentScale.Crop,
                    modifier = if (index == selectedImageIndex) {
                        Modifier
                            .alpha(progress)
                            .size(72.dp)
                            .border(
                                width = 4.dp,
                                color = MaterialTheme.colors.photoSelected,
                                shape = RoundedCornerShape(28)
                            )
                            .clip(MaterialTheme.shapes.medium)
                    } else {
                        Modifier
                            .alpha(progress)
                            // .absoluteOffset(x = (4 * (1-progress)).dp)
                            .size(72.dp)
                            .clip(MaterialTheme.shapes.medium)
                            .clickable(onClick = { selectedImageIndex = index })
                    }
                )
            }
        }
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PuppyPhotosPreview() {
    PreviewSurface {
        PuppyPhotos(Modifier.fillMaxWidth(), photoList = Puppy().puppyPhotoUrlList)
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PuppyPhotosPreviewDark() {
    PreviewSurface(darkTheme = true) {
        PuppyPhotos(Modifier.fillMaxWidth(), photoList = Puppy().puppyPhotoUrlList)
    }
}
