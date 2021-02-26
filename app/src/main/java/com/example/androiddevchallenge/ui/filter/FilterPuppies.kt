package com.example.androiddevchallenge.ui.filter

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
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