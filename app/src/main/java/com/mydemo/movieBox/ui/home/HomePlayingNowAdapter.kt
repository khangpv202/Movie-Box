package com.mydemo.movieBox.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mydemo.movieBox.R
import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import com.mydemo.base.convertToUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.home_playing_now_rv_item.view.*

class HomePlayingNowAdapter(val onClickCallBack: (Int?) -> Unit) :
    RecyclerView.Adapter<HomePlayingNowAdapter.ViewHolder>() {
    private val items = ArrayList<MovieListResponseDTO.Result>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_playing_now_rv_item,
                parent,
                false
            )
        )
    }

    fun submitList(newItems: List<MovieListResponseDTO.Result>) {
        val diffResult = DiffUtil.calculateDiff(MovieDiffCallback(this.items, newItems))
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MovieListResponseDTO.Result) = with(itemView) {
            ivPlayingNowPoster.tag = item.posterPath
            Glide.with(itemView.context).load(item.posterPath?.convertToUri())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .apply(
                    RequestOptions()
                        .override(
                            this.resources.getDimension(R.dimen.home_playing_now_width).toInt(),
                            this.resources.getDimension(R.dimen.home_playing_now_height).toInt()
                        )
                )
                .into(ivPlayingNowPoster)
            itemView.setOnClickListener {
                onClickCallBack.invoke(item.id)
            }
        }
    }
}