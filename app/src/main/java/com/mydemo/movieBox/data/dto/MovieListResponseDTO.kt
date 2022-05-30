package com.mydemo.movieBox.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by khangpv
 * FinOs
 */
class MovieListResponseDTO {
    @SerializedName("results")
    @Expose
    val results: List<Result>? = null

    @SerializedName("total_pages")
    @Expose
    val totalPages: Int? = null

    inner class Result {
        @SerializedName("adult")
        @Expose
        val adult: Boolean? = null

        @SerializedName("id")
        @Expose
        val id: Int? = null

        @SerializedName("poster_path")
        @Expose
        val posterPath: String? = null

        @SerializedName("release_date")
        @Expose
        val releaseDate: String? = null

        @SerializedName("title")
        @Expose
        val title: String? = null

        @SerializedName("vote_average")
        @Expose
        val voteAverage: Double? = null
    }
}