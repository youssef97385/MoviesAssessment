package com.example.moviesassesment.domain.use_cases.get_movies

import com.example.moviesassesment.common.Resource
import com.example.moviesassesment.data.remote.dto.movie_detail_dto.toMovieDetail
import com.example.moviesassesment.data.remote.dto.movies_list_dto.MovieDto
import com.example.moviesassesment.data.remote.dto.movies_list_dto.toMovie
import com.example.moviesassesment.domain.model.Movie
import com.example.moviesassesment.domain.model.MovieDetail
import com.example.moviesassesment.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository,
) {
    operator fun invoke(movieId: Int): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getMovieById(movieId).toMovieDetail()
            emit(Resource.Success(movie))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Some thing went wrong"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check the internet connection"))
        }
    }
}