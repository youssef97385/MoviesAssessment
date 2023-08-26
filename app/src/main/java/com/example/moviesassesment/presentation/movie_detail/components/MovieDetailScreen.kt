package com.example.moviesassesment.presentation.movie_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.moviesassesment.presentation.movie_detail.MovieDetailViewModel
import java.time.format.TextStyle

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieDetailScreen(viewModel: MovieDetailViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            AsyncImage(
                model = state.movie?.imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .height(300.dp)
            )

            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text(
                    text = state.movie?.title ?: "",
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = state.movie?.formattedDate ?: "",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Budget: ${state.movie?.formattedBudget}",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Revenue: ${state.movie?.formattedRevenue}",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Languages:",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(4.dp))

                FlowRow(

                    modifier = Modifier.fillMaxWidth()
                ) {
                    state.movie?.spokenLanguages?.forEach() { tag ->
                        TagUi(tag = tag)
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }


                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Genres:",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(4.dp))

                FlowRow(

                    modifier = Modifier.fillMaxWidth()
                ) {
                    state.movie?.genresNames?.forEach() { tag ->
                        TagUi(tag = tag)
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }


                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                ) {
                    Text(
                        text = state.movie?.overview ?: "",
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.bodySmall,
                        softWrap = true,
                    )

                }

                PreviewLongTextDemo()

            }

        }





        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun LongTextDemo() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun PreviewLongTextDemo() {
    LongTextDemo()
}