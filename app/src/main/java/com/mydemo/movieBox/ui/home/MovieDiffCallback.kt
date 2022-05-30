package com.mydemo.movieBox.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.mydemo.movieBox.data.dto.MovieListResponseDTO

/**
 * Created by khangpv
 * FinOs
 */
class MovieDiffCallback(
    private val oldListResponse: List<MovieListResponseDTO.Result>,
    private val newListResponse: List<MovieListResponseDTO.Result>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldListResponse.size

    override fun getNewListSize() = newListResponse.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldListResponse[oldItemPosition].id == newListResponse[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldListResponse[oldItemPosition].id == newListResponse[newItemPosition].id
    }
}