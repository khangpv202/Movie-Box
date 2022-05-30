package com.mydemo.movieBox.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.mydemo.movieBox.R
import com.mydemo.base.BaseDialogFragment
import com.mydemo.base.convertToUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.dialog_movie_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by khangpv.
 * FinOs
 */
private const val ARG_MOVIE_ID = "movieId"

class DetailDialogFragment : BaseDialogFragment() {
    override fun getLayoutId() = R.layout.dialog_movie_detail
    private val movieDetailViewModel: DetailViewModel by viewModel()
    private val detailGenresAdapter = DetailGenresAdapter()

    companion object {
        fun getInstance(movieId: Int): DetailDialogFragment {
            val f = DetailDialogFragment()
            val args = Bundle()
            args.putInt(ARG_MOVIE_ID, movieId)
            f.arguments = args
            return f
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivBack.setOnClickListener {
            dismiss()
        }
        val movieId =
            arguments?.getInt(ARG_MOVIE_ID) ?: kotlin.run { throw Exception("missing movieId") }
        rvGenres.adapter = detailGenresAdapter
        movieDetailViewModel.getMovieDetail(movieId)
        movieDetailViewModel.movieDetailLiveData.observe(this, Observer {
            Glide.with(this)
                .load(it.posterPath?.convertToUri())
                .placeholder(android.R.color.darker_gray)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(ivPoster)
            tvTitle.text = it.title
            tvIssueDateAndDuration.text = movieDetailViewModel.combineIssueDateAndDuration(it)
            tvOverviewDetail.text = it.overview
            detailGenresAdapter.submitList(it.genres ?: listOf())
        })
        setDividerForGenres()
    }

    private fun setDividerForGenres() {
        ContextCompat.getDrawable(
            requireActivity(),
            R.drawable.detail_genres_divider
        )?.let { drawable ->
            rvGenres.addItemDecoration(
                DividerItemDecoration(requireActivity(), DividerItemDecoration.HORIZONTAL).apply {
                    setDrawable(drawable)
                }
            )
        }

    }
}