package com.mydemo.movieBox.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.mydemo.movieBox.R
import com.mydemo.movieBox.data.network.MovieState
import com.mydemo.movieBox.ui.detail.DetailDialogFragment
import com.mydemo.base.BaseActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeActivity : BaseActivity<HomeViewModel>() {
    private lateinit var homeMostPopularAdapter: HomeMostPopularAdapter
    private lateinit var homePlayingNowAdapter: HomePlayingNowAdapter
    private val duration = 15000
    private val playingNowViewModel: PlayingNowViewModel by viewModel()
    private val mostPopularViewModel: MostPopularViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeMostPopularAdapter = HomeMostPopularAdapter { showMovieDetailFragment(it) }
        homePlayingNowAdapter = HomePlayingNowAdapter { showMovieDetailFragment(it) }
        rvPlayingNow.adapter = homePlayingNowAdapter
        rvMostPopular.adapter = homeMostPopularAdapter
        setDividerForMostPopularMovie()
        playingNowViewModel.fetchPlayingNowMovies()
        observer()
    }

    private fun observer() {
        playingNowViewModel.playingNowLiveData.observe(this, Observer {
            homePlayingNowAdapter.submitList(it.results ?: ArrayList())
        })
        mostPopularViewModel.mostPopularMovieLiveDataResponse.observe(this, Observer {
            homeMostPopularAdapter.submitList(it)
        })

        mostPopularViewModel.movieStateLiveData.observe(this, Observer {
            if (it == MovieState.ERROR) {
                val mySnackBar = Snackbar.make(
                    findViewById(R.id.llWholeLayout),
                    R.string.home_error_happen, Snackbar.LENGTH_SHORT
                )

                mySnackBar.setAction(R.string.home_retry) {
                    mostPopularViewModel.retry()
                    mySnackBar.dismiss()
                }.duration = duration
                mySnackBar.show()
            }
        })
    }

    private fun setDividerForMostPopularMovie() {
        ContextCompat.getDrawable(this@HomeActivity, R.drawable.home_popular_divider)
            ?.let { drawable ->
                rvMostPopular.addItemDecoration(
                    DividerItemDecoration(this, DividerItemDecoration.VERTICAL).apply {
                        setDrawable(drawable)
                    }
                )
            }

    }

    private fun showMovieDetailFragment(movieId: Int?) {
        movieId?.let {
            DetailDialogFragment.getInstance(movieId)
                .show(supportFragmentManager, "detailDialogFragment")
        } ?: kotlin.run {
            Toast.makeText(this, "movie id cannot be null", Toast.LENGTH_LONG).show()
        }
    }

    override fun getViewModel(): HomeViewModel {
        val viewModel: HomeViewModel by viewModel()
        return viewModel
    }
}
