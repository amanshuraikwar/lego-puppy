package com.example.androiddevchallenge.ui.actionbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.LegoPuppyTheme

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
    LegoPuppyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyActionBar(Modifier.fillMaxWidth())
        }
    }
}