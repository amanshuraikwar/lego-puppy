package com.example.androiddevchallenge.ui.puppydetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.util.PreviewSurface
import com.example.androiddevchallenge.util.location
import com.example.androiddevchallenge.util.onSurfaceSecondary

@Composable
fun PuppyProp(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    iconTint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    propName: String,
) {
    Row(
        modifier,
        verticalAlignment = Alignment.Bottom
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(18.dp)
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = propName,
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium),
            color = MaterialTheme.colors.onSurfaceSecondary,
        )
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PuppyPropPreview() {
    PreviewSurface {
        PuppyProp(
            imageVector = Icons.Rounded.Phone,
            iconTint = MaterialTheme.colors.location,
            propName = "Pupprop"
        )
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PuppyPropPreviewDark() {
    PreviewSurface(darkTheme = true) {
        PuppyProp(
            imageVector = Icons.Rounded.Phone,
            iconTint = MaterialTheme.colors.location,
            propName = "Pupprop"
        )
    }
}