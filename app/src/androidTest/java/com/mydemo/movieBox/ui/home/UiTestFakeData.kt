package com.mydemo.movieBox.ui.home

import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import com.google.gson.Gson

/**
 * Created by khangpv
 * FinOs
 */
object UiTestFakeData {
    fun mockPlayingNowWithThreeItems(): MovieListResponseDTO {
        val result =
            "{\n  \"dates\": {\n    \"maximum\": \"2021-07-01\",\n    \"minimum\": \"2021-05-14\"\n  },\n  \"page\": 1,\n  \"results\": [\n    {\n      \"adult\": false,\n      \"backdrop_path\": \"/620hnMVLu6RSZW6a5rwO8gqpt0t.jpg\",\n      \"genre_ids\": [\n        16,\n        35,\n        10751,\n        14\n      ],\n      \"id\": 508943,\n      \"original_language\": \"en\",\n      \"original_title\": \"Luca\",\n      \"overview\": \"Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.\",\n      \"popularity\": 6852.159,\n      \"poster_path\": \"/7rhzEufovmmUqVjcbzMHTBQ2SCG.jpg\",\n      \"release_date\": \"2021-06-17\",\n      \"title\": \"Luca\",\n      \"video\": false,\n      \"vote_average\": 8.2,\n      \"vote_count\": 1147\n    },\n    {\n      \"adult\": false,\n      \"backdrop_path\": \"/z2UtGA1WggESspi6KOXeo66lvLx.jpg\",\n      \"genre_ids\": [\n        878,\n        53,\n        27\n      ],\n      \"id\": 520763,\n      \"original_language\": \"en\",\n      \"original_title\": \"A Quiet Place Part II\",\n      \"overview\": \"Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.\",\n      \"popularity\": 5337.541,\n      \"poster_path\": \"/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg\",\n      \"release_date\": \"2021-05-21\",\n      \"title\": \"A Quiet Place Part II\",\n      \"video\": false,\n      \"vote_average\": 7.4,\n      \"vote_count\": 461\n    },\n    {\n      \"adult\": false,\n      \"backdrop_path\": \"/mYM8x2Atv4MaLulaV0KVJWI1Djv.jpg\",\n      \"genre_ids\": [\n        28,\n        80,\n        53\n      ],\n      \"id\": 804435,\n      \"original_language\": \"en\",\n      \"original_title\": \"Vanquish\",\n      \"overview\": \"Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.\",\n      \"popularity\": 900.333,\n      \"poster_path\": \"/AoWY1gkcNzabh229Icboa1Ff0BM.jpg\",\n      \"release_date\": \"2021-04-16\",\n      \"title\": \"Vanquish\",\n      \"video\": false,\n      \"vote_average\": 6,\n      \"vote_count\": 129\n    }\n  ],\n  \"total_pages\": 54,\n  \"total_results\": 1076\n}"
        return Gson().fromJson(result, MovieListResponseDTO::class.java)
    }

    fun mockPopularWithThreeItemsPerPageAndTotalPageIsOne(): MovieListResponseDTO {
        val result =
            "{\n  \"dates\": {\n    \"maximum\": \"2021-07-01\",\n    \"minimum\": \"2021-05-14\"\n  },\n  \"page\": 1,\n  \"results\": [\n    {\n      \"adult\": false,\n      \"backdrop_path\": \"/620hnMVLu6RSZW6a5rwO8gqpt0t.jpg\",\n      \"genre_ids\": [\n        16,\n        35,\n        10751,\n        14\n      ],\n      \"id\": 508943,\n      \"original_language\": \"en\",\n      \"original_title\": \"Luca\",\n      \"overview\": \"Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.\",\n      \"popularity\": 6852.159,\n      \"poster_path\": \"/7rhzEufovmmUqVjcbzMHTBQ2SCG.jpg\",\n      \"release_date\": \"2021-06-17\",\n      \"title\": \"Luca\",\n      \"video\": false,\n      \"vote_average\": 8.2,\n      \"vote_count\": 1147\n    },\n    {\n      \"adult\": false,\n      \"backdrop_path\": \"/z2UtGA1WggESspi6KOXeo66lvLx.jpg\",\n      \"genre_ids\": [\n        878,\n        53,\n        27\n      ],\n      \"id\": 520763,\n      \"original_language\": \"en\",\n      \"original_title\": \"A Quiet Place Part II\",\n      \"overview\": \"Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.\",\n      \"popularity\": 5337.541,\n      \"poster_path\": \"/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg\",\n      \"release_date\": \"2021-05-21\",\n      \"title\": \"A Quiet Place Part II\",\n      \"video\": false,\n      \"vote_average\": 7.4,\n      \"vote_count\": 461\n    },\n    {\n      \"adult\": false,\n      \"backdrop_path\": \"/mYM8x2Atv4MaLulaV0KVJWI1Djv.jpg\",\n      \"genre_ids\": [\n        28,\n        80,\n        53\n      ],\n      \"id\": 804435,\n      \"original_language\": \"en\",\n      \"original_title\": \"Vanquish\",\n      \"overview\": \"Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.\",\n      \"popularity\": 900.333,\n      \"poster_path\": \"/AoWY1gkcNzabh229Icboa1Ff0BM.jpg\",\n      \"release_date\": \"2021-04-16\",\n      \"title\": \"Vanquish\",\n      \"video\": false,\n      \"vote_average\": 6,\n      \"vote_count\": 129\n    }\n  ],\n  \"total_pages\": 1,\n  \"total_results\": 1076\n}"
        return Gson().fromJson(result, MovieListResponseDTO::class.java)
    }

    fun mockPopularWithThreeItemsPerPageAndTotalPageIsSix(): MovieListResponseDTO {
        val result =
            "{\n  \"dates\": {\n    \"maximum\": \"2021-07-01\",\n    \"minimum\": \"2021-05-14\"\n  },\n  \"page\": 1,\n  \"results\": [\n    {\n      \"adult\": false,\n      \"backdrop_path\": \"/620hnMVLu6RSZW6a5rwO8gqpt0t.jpg\",\n      \"genre_ids\": [\n        16,\n        35,\n        10751,\n        14\n      ],\n      \"id\": 508943,\n      \"original_language\": \"en\",\n      \"original_title\": \"Luca\",\n      \"overview\": \"Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.\",\n      \"popularity\": 6852.159,\n      \"poster_path\": \"/7rhzEufovmmUqVjcbzMHTBQ2SCG.jpg\",\n      \"release_date\": \"2021-06-17\",\n      \"title\": \"Luca\",\n      \"video\": false,\n      \"vote_average\": 8.2,\n      \"vote_count\": 1147\n    },\n    {\n      \"adult\": false,\n      \"backdrop_path\": \"/z2UtGA1WggESspi6KOXeo66lvLx.jpg\",\n      \"genre_ids\": [\n        878,\n        53,\n        27\n      ],\n      \"id\": 520763,\n      \"original_language\": \"en\",\n      \"original_title\": \"A Quiet Place Part II\",\n      \"overview\": \"Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.\",\n      \"popularity\": 5337.541,\n      \"poster_path\": \"/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg\",\n      \"release_date\": \"2021-05-21\",\n      \"title\": \"A Quiet Place Part II\",\n      \"video\": false,\n      \"vote_average\": 7.4,\n      \"vote_count\": 461\n    },\n    {\n      \"adult\": false,\n      \"backdrop_path\": \"/mYM8x2Atv4MaLulaV0KVJWI1Djv.jpg\",\n      \"genre_ids\": [\n        28,\n        80,\n        53\n      ],\n      \"id\": 804435,\n      \"original_language\": \"en\",\n      \"original_title\": \"Vanquish\",\n      \"overview\": \"Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.\",\n      \"popularity\": 900.333,\n      \"poster_path\": \"/AoWY1gkcNzabh229Icboa1Ff0BM.jpg\",\n      \"release_date\": \"2021-04-16\",\n      \"title\": \"Vanquish\",\n      \"video\": false,\n      \"vote_average\": 6,\n      \"vote_count\": 129\n    }\n  ],\n  \"total_pages\": 6,\n  \"total_results\": 1076\n}"
        return Gson().fromJson(result, MovieListResponseDTO::class.java)
    }
    fun mockPlayingNowWithZeroItem(): MovieListResponseDTO {
        val result = "{\n" +
                "  \"dates\": {\n" +
                "    \"maximum\": \"2021-07-01\",\n" +
                "    \"minimum\": \"2021-05-14\"\n" +
                "  },\n" +
                "  \"page\": 1,\n" +
                "  \"results\": [],\n" +
                "  \"total_pages\": 54,\n" +
                "  \"total_results\": 1076\n" +
                "}"
        return Gson().fromJson(result, MovieListResponseDTO::class.java)
    }
}