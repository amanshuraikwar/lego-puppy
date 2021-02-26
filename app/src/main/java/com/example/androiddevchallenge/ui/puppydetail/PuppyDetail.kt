package com.example.androiddevchallenge.ui.puppydetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.Male
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.onSurfaceSecondary
import com.example.androiddevchallenge.ui.theme.LegoPuppyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyDetail(
    modifier: Modifier = Modifier,
    puppy: Puppy,
    upPress: () -> Unit = {}
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxHeight()
    ) {
        Column(
            modifier
        ) {
            CoilImage(
                data = puppy.imageUrl,
                contentDescription = null,
                fadeIn = true,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(MaterialTheme.colors.primary)
            )

            Text(
                text = puppy.name,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                color = MaterialTheme.colors.onSurface
            )

            Text(
                text = puppy.breed,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp),
                color = MaterialTheme.colors.onSurface
            )

            Row(
                Modifier.padding(16.dp),
            ) {
                PuppyProp(
                    imageVector = Icons.Rounded.Pets,
                    propName = puppy.breed.replace(" ", "\n")
                )

                Spacer(modifier = Modifier.size(16.dp))

                PuppyProp(
                    imageVector = when (puppy.gender) {
                        Puppy.Gender.Male -> Icons.Rounded.Male
                        Puppy.Gender.Female -> Icons.Rounded.Female
                    },
                    propName = puppy.gender.toString()
                )
            }
        }
    }
}

@Composable
fun PuppyProp(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    propName: String,
) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = propName,
            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PuppyDetailPreview() {
    LegoPuppyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyDetail(Modifier.fillMaxHeight(), Puppy())
        }
    }
}