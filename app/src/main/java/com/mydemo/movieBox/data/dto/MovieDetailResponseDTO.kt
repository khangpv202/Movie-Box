package com.mydemo.movieBox.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by khangpv.
 * FinOs
 */
class MovieDetailResponseDTO {
    @SerializedName("genres")
    @Expose
    val genres: List<Genre>? = null

    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("overview")
    @Expose
    val overview: String? = null

    @SerializedName("poster_path")
    @Expose
    val posterPath: String? = null

    @SerializedName("release_date")
    @Expose
    val releaseDate: String? = null

    @SerializedName("revenue")
    @Expose
    val revenue: Int? = null

    @SerializedName("runtime")
    @Expose
    val runtime: Int? = null

    @SerializedName("title")
    @Expose
    val title: String? = null

    class Genre {
        @SerializedName("id")
        @Expose
        val id: Int? = null

        @SerializedName("name")
        @Expose
        val name: String? = null
    }
}