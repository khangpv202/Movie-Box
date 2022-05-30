package com.mydemo.movieBox.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mydemo.movieBox.R
import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import com.mydemo.base.convertToUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.home_most_popular_rv_item.view.*

class HomeMostPopularAdapter(val onClickCallBack: (Int?) -> Unit) :
    PagedListAdapter<MovieListResponseDTO.Result, HomeMostPopularAdapter.ViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_most_popular_rv_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MovieListResponseDTO.Result?) = with(itemView) {
            Glide.with(itemView.context).load(item?.posterPath?.convertToUri())
                .placeholder(android.R.color.darker_gray)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(poster)
            movieTitle.text = item?.title
            releaseDate.text = item?.releaseDate
            rating.setRatingValue(item?.voteAverage ?: 0.0)
            itemView.setOnClickListener {
                onClickCallBack.invoke(item?.id)
            }
        }
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<MovieListResponseDTO.Result>() {
            override fun areItemsTheSame(
                oldItem: MovieListResponseDTO.Result,
                newItem: MovieListResponseDTO.Result
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MovieListResponseDTO.Result,
                newItem: MovieListResponseDTO.Result
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}