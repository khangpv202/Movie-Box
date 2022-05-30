package com.mydemo.movieBox

import com.mydemo.movieBox.data.MovieRepository
import com.mydemo.movieBox.data.network.MovieService
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MovieRepositoryTest {
    @Mock
    lateinit var movieService: MovieService
    private lateinit var movieRepository: MovieRepository

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
        movieRepository = MovieRepository(movieService)
    }

    @Test
    fun testGetPlayingNowListSuccess() {
        val fakeResultData = UnitTestHomeFakeData.fakeResultData()
        Mockito.`when`(movieService.getListPlayingMovies())
            .thenReturn(Single.just(fakeResultData))
        val result = movieRepository.getListPlayingMovies().blockingGet().results
        Assert.assertEquals(fakeResultData.results?.size, result?.size)
        val dataAtFirst = fakeResultData.results?.get(0)
        val resultAtFirst = result?.get(0)
        Assert.assertEquals(dataAtFirst, resultAtFirst)
    }

    @Test
    fun testGetPlayingNowErrorNetworkConnection() {
        Mockito.`when`(movieService.getListPlayingMovies())
            .thenAnswer { throw UnknownHostException() }
        try {
            movieRepository.getListPlayingMovies().blockingGet().results
        } catch (e: Exception) {
            Assert.assertTrue(e is UnknownHostException)
        }
    }

    @Test
    fun testGetPlayingNowErrorSocketTimeout() {
        Mockito.`when`(movieService.getListPlayingMovies())
            .thenAnswer { throw SocketTimeoutException() }
        try {
            movieRepository.getListPlayingMovies().blockingGet().results
        } catch (e: Exception) {
            Assert.assertTrue(e is SocketTimeoutException)
        }
    }

    @Test
    fun testGetMovieDetailSuccess() {
        val fakeResultData = UnitTestDetailFakeData.fakeMovieDetailDTO()
        Mockito.`when`(movieService.getMovieDetail(fakeResultData.id!!))
            .thenReturn(Single.just(fakeResultData))
        val result = movieRepository.getMovieDetail(fakeResultData.id!!).blockingGet()
        Assert.assertEquals(fakeResultData.title, result?.title)
        Assert.assertEquals(fakeResultData.runtime, result?.runtime)
        Assert.assertEquals(fakeResultData.id, result?.id)
    }

    @Test
    fun testGetMovieDetailNetworkConnection() {
        val movieId = 123
        Mockito.`when`(movieService.getMovieDetail(movieId))
            .thenAnswer { throw UnknownHostException() }
        try {
            movieRepository.getMovieDetail(movieId).blockingGet()
        } catch (e: Exception) {
            Assert.assertTrue(e is UnknownHostException)
        }
    }
}
