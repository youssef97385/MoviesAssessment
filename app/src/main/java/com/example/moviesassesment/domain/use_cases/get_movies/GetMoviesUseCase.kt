package com.example.moviesassesment.domain.use_cases.get_movies

import com.example.moviesassesment.common.Resource
import com.example.moviesassesment.data.remote.dto.movies_list_dto.toMovie
import com.example.moviesassesment.domain.model.Movie
import com.example.moviesassesment.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository,
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = repository.getMovies().map { it.toMovie() }
            emit(Resource.Success(movies))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Some thing went wrong"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Check the internet connection"))
        }
    }
}