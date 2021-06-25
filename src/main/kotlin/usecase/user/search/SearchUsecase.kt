package usecase.user.search

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Response.success
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import util.api.RiotAPI
import util.api.dto.SummonerInfoResult
import util.logger.Logger

class SearchUsecase (
    private val baseUrl: String
) {

    companion object: Logger

    private lateinit var riotAPI: RiotAPI
    private val client: OkHttpClient

    init {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        client = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()

        createRiotAPI()
    }

    fun searchByUserName(userName: String): SummonerInfoResult {
        val request = riotAPI.getSummonerInfo(userName, System.getenv("RIOT_API_KEY"))
        var summonerInfoResult: SummonerInfoResult? = null

        request.enqueue(object : Callback<SummonerInfoResult> {
            override fun onResponse(call: Call<SummonerInfoResult>, response: Response<SummonerInfoResult>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    summonerInfoResult = data
                }
            }

            override fun onFailure(call: Call<SummonerInfoResult>, t: Throwable) {
            }
        })

        return summonerInfoResult ?: SummonerInfoResult("1", "1", "1", "1", 1, 1, 1)
    }

    private fun createRiotAPI() {
        riotAPI = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiotAPI::class.java)
    }
}