package com.mydemo.movieBox.ui.home

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withTagValue
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mydemo.movieBox.R
import com.mydemo.movieBox.base.BaseUiTest
import com.mydemo.movieBox.base.RecyclerViewItemCountAssertion
import com.mydemo.movieBox.data.network.MovieService
import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.mock.declareMock
import org.mockito.BDDMockito.anyInt
import org.mockito.BDDMockito.given

/**
 * Created by khangpv
 * FinOs
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityTest : BaseUiTest<HomeActivity>(HomeActivity::class.java) {
    private fun startActivity() {
        val intent = Intent()
        activityRule.launchActivity(intent)
    }

    @Test
    fun testPlayingNowWithThreeItem() {
        //fake result with result list size = 3 items.
        val fakeResultData = UiTestFakeData.mockPlayingNowWithThreeItems()
        val fakePopularResultData =
            UiTestFakeData.mockPopularWithThreeItemsPerPageAndTotalPageIsOne()
        declareMock<MovieService> {
            given(this.getListPlayingMovies()).willReturn(Single.just(fakeResultData))
            given(this.getListPopularMoviesByPage(anyInt()))
                .willReturn(Single.just(fakePopularResultData))
        }
        startActivity()
        Espresso.onView(withId(R.id.rvPlayingNow))
            .check(ViewAssertions.matches((ViewMatchers.isDisplayed())))
        fakeResultData.results?.forEach {
            Espresso.onView(withTagValue(`is`(it.posterPath!!)))
                .check(ViewAssertions.matches((ViewMatchers.isDisplayed())))
        }
        Espresso.onView(withId(R.id.rvPlayingNow)).check(RecyclerViewItemCountAssertion(3))
    }

    @Test
    fun testPlayingNowWithEmptyList() {
        //fake result with result list size = 0 items.
        val fakeResultData = UiTestFakeData.mockPlayingNowWithZeroItem()
        val fakePopularResultData =
            UiTestFakeData.mockPopularWithThreeItemsPerPageAndTotalPageIsOne()
        declareMock<MovieService> {
            given(this.getListPlayingMovies()).willReturn(Single.just(fakeResultData))
            given(this.getListPopularMoviesByPage(anyInt()))
                .willReturn(Single.just(fakePopularResultData))
        }
        startActivity()
        Espresso.onView(withId(R.id.rvPlayingNow))
            .check(ViewAssertions.matches((ViewMatchers.isDisplayed())))
        Espresso.onView(withId(R.id.rvPlayingNow)).check(RecyclerViewItemCountAssertion(0))
    }

    @Test
    fun testGetPopularWithThreeItemsAndTotalPageIsOne() {
        val fakePlayingNowResultData = UiTestFakeData.mockPlayingNowWithThreeItems()
        val fakePopularResultData =
            UiTestFakeData.mockPopularWithThreeItemsPerPageAndTotalPageIsOne()
        declareMock<MovieService> {
            given(this.getListPlayingMovies())
                .willReturn(Single.just(fakePlayingNowResultData))
            given(this.getListPopularMoviesByPage(anyInt()))
                .willReturn(Single.just(fakePopularResultData))
        }
        startActivity()
        Espresso.onView(withId(R.id.rvMostPopular)).check(RecyclerViewItemCountAssertion(3 * 1))
    }

    @Test
    fun testGetPopularWithThreeItemsPerPageAndTotalPageIsSix() {
        val fakePlayingNowResultData = UiTestFakeData.mockPlayingNowWithThreeItems()
        val fakePopularResultData =
            UiTestFakeData.mockPopularWithThreeItemsPerPageAndTotalPageIsSix()
        declareMock<MovieService> {
            given(this.getListPlayingMovies())
                .willReturn(Single.just(fakePlayingNowResultData))
            given(this.getListPopularMoviesByPage(anyInt()))
                .willReturn(Single.just(fakePopularResultData))
        }
        startActivity()
        Espresso.onView(withId(R.id.rvMostPopular)).check(RecyclerViewItemCountAssertion(3 * 6))
    }
}