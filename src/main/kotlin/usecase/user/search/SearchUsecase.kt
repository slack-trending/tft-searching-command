package usecase.user.search

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import util.api.RiotAPI
import util.api.dto.MatchHistoryResult
import util.api.dto.SummonerInfoResult
import util.api.exception.ReceiveFailedException
import util.logger.Logger

class SearchUsecase (
    private val baseUrl: String,
    private val tftSearchBaseUrl: String
) {

    companion object: Logger

    private lateinit var riotAPI: RiotAPI
    private lateinit var tftAPI: RiotAPI

    private val client: OkHttpClient = OkHttpClient().newBuilder()
        .build()

    init {
        createRiotAPI()
    }

    fun searchByUserName(userName: String): SummonerInfoResult {
        val call = riotAPI.getSummonerInfo(userName, System.getenv("RIOT_API_KEY"))

        val response = call.execute()
        val body = response.body()

        return body ?: throw ReceiveFailedException()
    }

    fun searchMatchHistoriesByPuuid(puuid: String): List<String> {
        val call = tftAPI.getMatchHistoryList(puuid, System.getenv("RIOT_API_KEY"))

        val response = call.execute()
        val body = response.body()

        return body ?: throw ReceiveFailedException()
    }

    fun searchMatchesByMatchIdList(matchIdList: List<String>): List<MatchHistoryResult> {
        val apiKey = System.getenv("RIOT_API_KEY")
        val matchHistory = mutableListOf<MatchHistoryResult>()

        matchIdList.forEach { matchId ->
            val call = tftAPI.getMatchHistory(matchId, apiKey)

            val response = call.execute()
            val body = response.body()

            if (body != null) matchHistory.add(body)
            else throw ReceiveFailedException()
        }

        return matchHistory
    }


    private fun createRiotAPI() {
        riotAPI = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiotAPI::class.java)

        tftAPI = Retrofit.Builder()
            .baseUrl(tftSearchBaseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiotAPI::class.java)
    }
}