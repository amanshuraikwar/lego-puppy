package com.example.androiddevchallenge.ui.puppydetail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PuppyBio(modifier: Modifier, bio: String) {
    Text(
        text = bio,
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
}