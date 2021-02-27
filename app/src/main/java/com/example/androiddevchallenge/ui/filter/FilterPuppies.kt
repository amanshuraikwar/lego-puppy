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
package com.example.androiddevchallenge.ui.filter

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.LegoPuppyTheme

@Composable
fun FilterPuppies() {
    val filters = listOf("Male", "Female", "Golder Retriever")
    LazyRow {
        items(filters) { item ->
            FilterItem(
                modifier = Modifier.padding(8.dp),
                filter = item
            )
        }
    }
}

@Composable
fun FilterItem(
    modifier: Modifier = Modifier,
    filter: String
) {
    Text(
        text = filter,
        modifier = modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.primary,
                MaterialTheme.shapes.small
            )
            .padding(8.dp)
    )
}

@Preview
@Composable
fun FilterItemPreview() {
    LegoPuppyTheme {
        Surface(color = MaterialTheme.colors.background) {
            FilterItem(filter = "Dogs")
        }
    }
}

@Preview
@Composable
fun FilterPuppiesPreview() {
    LegoPuppyTheme {
        Surface(color = MaterialTheme.colors.background) {
            FilterPuppies()
        }
    }
}
