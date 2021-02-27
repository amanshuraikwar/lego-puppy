package com.example.androiddevchallenge.ui.goodbois

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy

@Composable
fun GoodBois(
    puppyList: List<Puppy>,
) {
    LazyRow(
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
    ) {
        items(puppyList) { item ->
            PuppyItemHorizontal(
                Modifier
                    .clickable(onClick = { })
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    ),
                puppy = item
            )
        }
    }
}