package com.mydemo.movieBox

import android.app.Application
import androidx.paging.PageKeyedDataSource
import com.mydemo.movieBox.data.MoviePagingSource
import com.mydemo.movieBox.data.MovieRepository
import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import com.mydemo.movieBox.data.network.MovieService
import com.mydemo.base.BaseViewModel
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


/**
 * Created by khangpv.
 * FinOs
 */
class MoviePagingSourceTest {
    private lateinit var movieRepository: MovieRepository

    @Mock
    lateinit var movieService: MovieService

    @Mock
    private lateinit var application: Application

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        movieRepository = MovieRepository(movieService)
    }

    @Test
    fun loadReturnsPageWhenOnSuccessfulLoadOfItemKeyedData() {
        val moviePagingSource = MoviePagingSource(movieRepository, BaseViewModel((application)))
        val fakeResultData = UnitTestHomeFakeData.fakeResultData()
        Mockito.`when`(movieService.getListPopularMoviesByPage(1))
            .thenReturn(Single.just(fakeResultData))
        var isAssertOk = false
        val callback =
            object : PageKeyedDataSource.LoadInitialCallback<Int, MovieListResponseDTO.Result>() {
                override fun onResult(
                    data: MutableList<MovieListResponseDTO.Result>,
                    previousPageKey: Int?,
                    nextPageKey: Int?
                ) {
                    Assert.assertEquals(fakeResultData.results?.size, data.size)
                    Assert.assertEquals(2, nextPageKey!!)
                    isAssertOk = true
                }

                override fun onResult(
                    data: MutableList<MovieListResponseDTO.Result>,
                    position: Int,
                    totalCount: Int,
                    previousPageKey: Int?,
                    nextPageKey: Int?
                ) {
                }
            }
        moviePagingSource.loadInitial(PageKeyedDataSource.LoadInitialParams(1, false), callback)
        Thread.sleep(2000)
        Assert.assertTrue(isAssertOk)
    }
}