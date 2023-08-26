package com.example.moviesassesment.presentation.movies_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviesassesment.domain.model.Movie

@Composable
fun MovieListItem(movie: Movie, onClicked: (Movie) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max).clickable {
                onClicked
            }
    ) {
        AsyncImage(
            model = movie.imageUrl,
            contentDescription = "",
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = movie.title,
                fontStyle = FontStyle.Italic,
                color = Color.LightGray,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = movie.year,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }


}