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

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.util.PreviewSurface

@Composable
fun PuppyBio(modifier: Modifier = Modifier, bio: String) {
    Text(
        text = bio,
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
}

@Preview
@Composable
fun PuppyBioPreview() {
    PreviewSurface {
        PuppyBio(
            bio = Puppy().bio
        )
    }
}

@Preview
@Composable
fun PuppyBioPreviewDark() {
    PreviewSurface(darkTheme = true) {
        PuppyBio(
            bio = Puppy().bio
        )
    }
}
