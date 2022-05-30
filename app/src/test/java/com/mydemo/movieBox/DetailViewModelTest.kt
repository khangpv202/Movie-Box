package com.mydemo.movieBox

import android.app.Application
import com.mydemo.movieBox.data.MovieRepository
import com.mydemo.movieBox.data.network.MovieService
import com.mydemo.movieBox.ui.detail.DetailViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by khangpv.
 * FinOs
 */
class DetailViewModelTest {
    @Mock
    lateinit var movieService: MovieService

    @Mock
    private lateinit var application: Application

    lateinit var detailViewModel: DetailViewModel

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
        detailViewModel = DetailViewModel(application, MovieRepository(movieService))
    }

    @Test
    fun testCombineIssueDateAndDuration() {
        val result =
            detailViewModel.combineIssueDateAndDuration(UnitTestDetailFakeData.fakeMovieDetailDTO())
        Assert.assertEquals("2021-05-21 1h 37m", result)
    }


}