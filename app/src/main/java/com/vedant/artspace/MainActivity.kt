@file:Suppress("PreviewMustBeTopLevelFunction")

package com.vedant.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vedant.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtImageAndText(title: Int, artist: Int, drawableResource: Int, artDescription: Int, OnNextClick: () -> Unit, OnPreviousClick:()-> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.background),
                contentScale = ContentScale.Crop
            )
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .statusBarsPadding()
            .safeDrawingPadding()
    ) {

        Image(
            painter = painterResource(drawableResource),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier=Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            ).clip(shape = RoundedCornerShape(16.dp))
        )

        Text(
            text = stringResource(title),
            fontSize = 36.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 40.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = stringResource(artist),
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )

        Text(
            text = stringResource(artDescription),
            modifier = Modifier.padding(top = 20.dp, start = 16.dp, end = 16.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))

    }
    Row(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.SpaceEvenly){

        Button(onClick = OnPreviousClick, shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Black),
            modifier = Modifier
        ) {
            Text(text = "Previous")

        }
        Button(
            onClick = OnNextClick,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Black),
            modifier = Modifier
        ) {
            Text(text = "Next")

        }

    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var currentArt by remember { mutableStateOf(1) }

    Surface(modifier = modifier.fillMaxSize()) {

        when (currentArt) {
            1 -> {
                ArtImageAndText(
                    title = R.string.title1,
                    artist = R.string.artist1,
                    drawableResource = R.drawable.monalisa,
                    artDescription = R.string.mona_lisa_summary,
                    OnNextClick = { currentArt = 2 },
                    OnPreviousClick = { currentArt = 1 }
                )
            }

            2 -> {
                ArtImageAndText(
                    title = R.string.title2,
                    artist = R.string.artist2,
                    drawableResource = R.drawable.creation_of_adam,
                    artDescription = R.string.creation_of_adam_summary,
                    OnNextClick = { currentArt = 3 },
                    OnPreviousClick = { currentArt = 1 }
                )

            }
            3 -> {
                ArtImageAndText(
                    title = R.string.title3,
                    artist = R.string.artist3,
                    drawableResource = R.drawable.girlwithpearlearring,
                    artDescription = R.string.girl_with_pearl_earring_summary,
                    OnNextClick = { currentArt = 4 },
                    OnPreviousClick = { currentArt = 2 }
                )
            }
            4 -> {
                ArtImageAndText(
                    title = R.string.title4,
                    artist = R.string.artist4,
                    drawableResource = R.drawable.kanagawawave,
                    artDescription = R.string.great_wave_summary,
                    OnNextClick = { currentArt = 5 },
                    OnPreviousClick = { currentArt = 3 }
                )
            }
            5 -> {
                ArtImageAndText(
                    title = R.string.title5,
                    artist = R.string.artist5,
                    drawableResource = R.drawable.liberty,
                    artDescription = R.string.liberty_leading_summary,
                    OnNextClick = { currentArt = 6 },
                    OnPreviousClick = { currentArt = 4 }
                )
            }
            6 -> {
                ArtImageAndText(
                    title = R.string.title6,
                    artist = R.string.artist6,
                    drawableResource = R.drawable.napoleon,
                    artDescription = R.string.napoleon_crossing_summary,
                    OnNextClick = { currentArt = 7 },
                    OnPreviousClick = { currentArt = 5 }
                )
            }
            7 -> {
                ArtImageAndText(
                    title = R.string.title7,
                    artist = R.string.artist7,
                    drawableResource = R.drawable.nighthawks,
                    artDescription = R.string.nighthawks_summary,
                    OnNextClick = { currentArt = 8 },
                    OnPreviousClick = { currentArt = 6 }
                )
            }
            8 -> {
                ArtImageAndText(
                    title = R.string.title8,
                    artist = R.string.artist8,
                    drawableResource = R.drawable.starrynight,
                    artDescription = R.string.starry_night_summary,
                    OnNextClick = { currentArt = 9 },
                    OnPreviousClick = { currentArt = 7 }
                )
            }
            9 -> {
                ArtImageAndText(
                    title = R.string.title9,
                    artist = R.string.artist9,
                    drawableResource = R.drawable.wanderer,
                    artDescription = R.string.wanderer_summary,
                    OnNextClick = { currentArt = 10 },
                    OnPreviousClick = { currentArt = 8 }
                )
            }
            10 -> {
                ArtImageAndText(
                    title = R.string.title10,
                    artist = R.string.artist10,
                    drawableResource = R.drawable.hamsadamayanti,
                    artDescription = R.string.hamsa_damayanti_summary,
                    OnNextClick = { currentArt = 10 },
                    OnPreviousClick = { currentArt = 9 }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}