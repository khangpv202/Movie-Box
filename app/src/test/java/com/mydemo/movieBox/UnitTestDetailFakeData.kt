package com.mydemo.movieBox

import com.mydemo.movieBox.data.dto.MovieDetailResponseDTO
import com.google.gson.Gson

/**
 * Created by khangpv.
 * FinOs
 */
object UnitTestDetailFakeData {
    fun fakeMovieDetailDTO(): MovieDetailResponseDTO {
        val result =
            "{\"adult\":false,\"backdrop_path\":\"/z2UtGA1WggESspi6KOXeo66lvLx.jpg\",\"belongs_to_collection\":{\"id\":521226,\"name\":\"A Quiet Place Collection\",\"poster_path\":\"/7WkFgOFJ6kKpqfEUo78zS3gjDlm.jpg\",\"backdrop_path\":\"/aYIWZ8SmnZt6rDCuIvXzzcnxjWC.jpg\"},\"budget\":61000000,\"genres\":[{\"id\":878,\"name\":\"Science Fiction\"},{\"id\":53,\"name\":\"Thriller\"},{\"id\":27,\"name\":\"Horror\"}],\"homepage\":\"https://www.aquietplacemovie.com\",\"id\":520763,\"imdb_id\":\"tt8332922\",\"original_language\":\"en\",\"original_title\":\"A Quiet Place Part II\",\"overview\":\"Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.\",\"popularity\":5250.562,\"poster_path\":\"/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg\",\"production_companies\":[{\"id\":2481,\"logo_path\":\"/nVEP2IHCDOBOldgDL4SSufitN9.png\",\"name\":\"Platinum Dunes\",\"origin_country\":\"US\"},{\"id\":29312,\"logo_path\":null,\"name\":\"Sunday Night\",\"origin_country\":\"US\"},{\"id\":4,\"logo_path\":\"/fycMZt242LVjagMByZOLUGbCvv3.png\",\"name\":\"Paramount\",\"origin_country\":\"US\"}],\"production_countries\":[{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"release_date\":\"2021-05-21\",\"revenue\":224400713,\"runtime\":97,\"spoken_languages\":[{\"english_name\":\"English\",\"iso_639_1\":\"en\",\"name\":\"English\"}],\"status\":\"Released\",\"tagline\":\"Silence is not enough.\",\"title\":\"A Quiet Place Part II\",\"video\":false,\"vote_average\":7.8,\"vote_count\":817}"
        return Gson().fromJson(result, MovieDetailResponseDTO::class.java)
    }
}