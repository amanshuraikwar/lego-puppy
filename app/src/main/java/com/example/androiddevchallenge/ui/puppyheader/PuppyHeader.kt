package com.example.androiddevchallenge.ui.puppyheader

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*

@ExperimentalStdlibApi
@Composable
fun PuppyHeader(modifier: Modifier = Modifier, heading: String) {
    Text(
        text = heading.uppercase(Locale.getDefault()),
        modifier = modifier.padding(top = 12.dp, start = 16.dp, end = 16.dp),
        style = MaterialTheme.typography.caption
    )
}