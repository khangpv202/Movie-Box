package com.mydemo.movieBox.ui.detail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mydemo.movieBox.R
import com.mydemo.movieBox.ui.home.UiTestFakeData
import com.mydemo.movieBox.base.BaseUiTest
import com.mydemo.movieBox.data.dto.MovieDetailResponseDTO
import com.mydemo.movieBox.data.network.MovieService
import com.mydemo.movieBox.ui.home.HomeActivity
import org.hamcrest.CoreMatchers.allOf
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.mock.declareMock

/**
 * Created by khangpv
 * FinOs
 */
@RunWith(AndroidJUnit4::class)
class DetailDialogFragmentTest : BaseUiTest<HomeActivity>(HomeActivity::class.java) {
    private val mockPlayingNowList = UiTestFakeData.mockPlayingNowWithThreeItems()
    private val mockPopularResultList = UiTestFakeData.mockPopularWithThreeItemsPerPageAndTotalPageIsOne()
    private val movieDetailResponse: MovieDetailResponseDTO = UITestDetailFakeData.mockMovieDetailDTO()

    private fun mockDataAndStartActivity() {
        declareMock<MovieService> {
            BDDMockito.given(this.getListPlayingMovies()).willReturn(Single.just(mockPlayingNowList))
            BDDMockito.given(this.getListPopularMoviesByPage(BDDMockito.anyInt())).willReturn(Single.just(mockPopularResultList))
            BDDMockito.given(this.getMovieDetail(BDDMockito.anyInt())).willReturn(Single.just(movieDetailResponse))
        }
        startActivity()
    }

    private fun startActivity() {
        val intent = Intent()
        activityRule.launchActivity(intent)
    }

    @Test
    fun testViewDetailWhenClickFromPlayingNowList() {
        mockDataAndStartActivity()
        onRecyclerViewClickAt(R.id.rvPlayingNow, 0)
        onView(withId(R.id.tvTitle)).check(matches(withText(movieDetailResponse.title)))
        onView(withId(R.id.tvOverviewDetail)).check(matches(withText(movieDetailResponse.overview)))
        onView(allOf(withId(R.id.tvGenresValue), withText("Comedy"))).check(matches(isDisplayed()))
    }

    @Test
    fun testViewDetailWhenClickFromMostPopularList() {
        mockDataAndStartActivity()
        onRecyclerViewClickAt(R.id.rvMostPopular, 0)
        onView(withId(R.id.tvTitle)).check(matches(withText(movieDetailResponse.title)))
        onView(withId(R.id.tvOverviewDetail)).check(matches(withText(movieDetailResponse.overview)))
        onView(allOf(
                withId(R.id.tvGenresValue),
                withText("Animation")
            )
        ).check(matches(isDisplayed()))
    }
}