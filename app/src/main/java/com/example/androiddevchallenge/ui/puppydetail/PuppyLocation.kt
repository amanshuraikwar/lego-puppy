package com.example.androiddevchallenge.ui.puppydetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.onSurfaceSecondary
import com.example.androiddevchallenge.ui.theme.green400

@Composable
fun PuppyLocation(modifier: Modifier = Modifier, location: String) {
    Row(
        modifier,
        verticalAlignment = Alignment.Bottom
    ) {
        Icon(
            imageVector = Icons.Rounded.LocationOn,
            contentDescription = null,
            tint = green400,
            modifier = Modifier.size(20.dp)
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = location,
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium),
            color = MaterialTheme.colors.onSurfaceSecondary,
        )
    }
}