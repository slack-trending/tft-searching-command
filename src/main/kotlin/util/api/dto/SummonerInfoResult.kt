package util.api.dto

import com.google.gson.annotations.SerializedName

class SummonerInfoResult (
    @SerializedName("id")
    val id: String,

    @SerializedName("accountId")
    val accountId: String,

    @SerializedName("puuid")
    val uuid: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("profileIconId")
    val profileIconId: Int,

    @SerializedName("revisionDate")
    val revisionDate: String,

    @SerializedName("summonerLevel")
    val summonerLevel: Int
)