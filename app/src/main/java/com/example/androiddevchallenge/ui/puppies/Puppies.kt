package com.example.androiddevchallenge.ui.puppies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Female
import androidx.compose.material.icons.twotone.Male
import androidx.compose.material.icons.twotone.NearMe
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.onSurfaceSecondary
import com.example.androiddevchallenge.ui.theme.LegoPuppyTheme
import com.example.androiddevchallenge.ui.theme.green400
import com.example.androiddevchallenge.ui.theme.pink400
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun Puppies(puppyList: List<Puppy>) {
    LazyColumn {
        items(puppyList) { item ->
            PuppyItem(
                Modifier.fillMaxWidth(),
                puppy = item
            )
        }
    }
}

@Composable
fun PuppyItem(modifier: Modifier = Modifier, puppy: Puppy) {
    Row(
        modifier.padding(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        CoilImage(
            data = puppy.imageUrl,
            contentDescription = null,
            fadeIn = true,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(96.dp)
                .background(MaterialTheme.colors.primary)
        )

        Column(
            Modifier.padding(start = 16.dp)
        ) {
            Text(
                puppy.name,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                puppy.breed,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(
                    imageVector = when (puppy.gender) {
                        Puppy.Gender.Male -> Icons.TwoTone.Male
                        Puppy.Gender.Female -> Icons.TwoTone.Female
                    },
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = pink400
                )

                Text(
                    "${puppy.gender}, ${puppy.age} years old",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurfaceSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.TwoTone.NearMe,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = green400
                )

                Text(
                    "${puppy.kmsAway} kms away",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurfaceSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                )
            }
        }
    }
}

@Preview(name = "Puppy Item")
@Composable
fun PuppyItemPreview() {
    LegoPuppyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyItem(
                puppy = Puppy()
            )
        }
    }
}

@Preview
@Composable
fun PuppiesPreview() {
    LegoPuppyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Puppies(
                puppyList = List(10) {
                    Puppy()
                }
            )
        }
    }
}