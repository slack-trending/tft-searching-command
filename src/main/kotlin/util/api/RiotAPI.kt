package util.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import util.api.dto.MatchHistoryResult
import util.api.dto.SummonerInfoResult

interface RiotAPI {
    @GET("lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummonerInfo(
        @Path("summonerName") summonerName: String,
        @Query("api_key") apiKey: String?
    ): Call<SummonerInfoResult>

    @GET("tft/match/v1/matches/by-puuid/{puuid}/ids")
    fun getMatchHistoryList(
        @Path("puuid") puuid: String,
        @Query("api_key") apiKey: String?
    ): Call<List<String>>

    @GET("tft/match/v1/matches/{matchId}")
    fun getMatchHistory(
        @Path("matchId") matchId: String,
        @Query("api_key") apiKey: String?
    ): Call<MatchHistoryResult>
}