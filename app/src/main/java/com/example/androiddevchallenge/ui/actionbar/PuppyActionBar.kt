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
package com.example.androiddevchallenge.ui.actionbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.util.PreviewSurface

@Composable
fun PuppyActionBar(modifier: Modifier = Modifier) {
    Text(
        text = "Lego Puppy",
        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
        modifier = modifier.padding(16.dp),
        color = MaterialTheme.colors.primary
    )
}

@Preview
@Composable
fun PuppyActionBarPreview() {
    PreviewSurface {
        PuppyActionBar(Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun PuppyActionBarPreviewDark() {
    PreviewSurface(darkTheme = true) {
        PuppyActionBar(Modifier.fillMaxWidth())
    }
}
