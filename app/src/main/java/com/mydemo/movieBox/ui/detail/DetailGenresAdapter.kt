package com.mydemo.movieBox.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mydemo.movieBox.R
import com.mydemo.movieBox.data.dto.MovieDetailResponseDTO
import kotlinx.android.synthetic.main.dialog_detail_genres_rv_item.view.*

class DetailGenresAdapter : RecyclerView.Adapter<DetailGenresAdapter.ViewHolder>() {
    private val items = ArrayList<MovieDetailResponseDTO.Genre>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dialog_detail_genres_rv_item,
                parent,
                false
            )
        )
    }

    fun submitList(newItems: List<MovieDetailResponseDTO.Genre>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MovieDetailResponseDTO.Genre) = with(itemView) {
            tvGenresValue.text = item.name
        }
    }
}