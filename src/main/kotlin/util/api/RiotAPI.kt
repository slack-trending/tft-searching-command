package util.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import util.api.dto.SummonerInfoResult

interface RiotAPI {
    @GET("lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummonerInfo(
        @Path("summonerName") summonerName: String,
        @Query("api_key") apiKey: String?
    ): Call<SummonerInfoResult>
}