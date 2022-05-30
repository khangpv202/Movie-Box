package com.mydemo.movieBox.ui.detail

import com.mydemo.movieBox.data.dto.MovieDetailResponseDTO
import com.google.gson.Gson

/**
 * Created by khangpv
 * FinOs
 */
object UITestDetailFakeData {
    fun mockMovieDetailDTO(): MovieDetailResponseDTO {
        val result =
            "{\"adult\":false,\"backdrop_path\":\"/620hnMVLu6RSZW6a5rwO8gqpt0t.jpg\",\"belongs_to_collection\":null,\"budget\":0,\"genres\":[{\"id\":16,\"name\":\"Animation\"},{\"id\":35,\"name\":\"Comedy\"},{\"id\":10751,\"name\":\"Family\"},{\"id\":14,\"name\":\"Fantasy\"}],\"homepage\":\"https://www.disneyplus.com/movies/luca/7K1HyQ6Hl16P\",\"id\":508943,\"imdb_id\":\"tt12801262\",\"original_language\":\"en\",\"original_title\":\"Luca\",\"overview\":\"Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.\",\"popularity\":6255.757,\"poster_path\":\"/jTswp6KyDYKtvC52GbHagrZbGvD.jpg\",\"production_companies\":[{\"id\":2,\"logo_path\":\"/wdrCwmRnLFJhEoH8GSfymY85KHT.png\",\"name\":\"Walt Disney Pictures\",\"origin_country\":\"US\"},{\"id\":3,\"logo_path\":\"/1TjvGVDMYsj6JBxOAkUHpPEwLf7.png\",\"name\":\"Pixar\",\"origin_country\":\"US\"}],\"production_countries\":[{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"release_date\":\"2021-06-17\",\"revenue\":11600000,\"runtime\":95,\"spoken_languages\":[{\"english_name\":\"English\",\"iso_639_1\":\"en\",\"name\":\"English\"},{\"english_name\":\"Italian\",\"iso_639_1\":\"it\",\"name\":\"Italiano\"}],\"status\":\"Released\",\"tagline\":\"\",\"title\":\"Luca\",\"video\":false,\"vote_average\":8.2,\"vote_count\":1596}"
        return Gson().fromJson(result, MovieDetailResponseDTO::class.java)
    }
}