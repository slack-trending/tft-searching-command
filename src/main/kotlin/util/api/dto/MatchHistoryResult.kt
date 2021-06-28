package util.api.dto

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

class MatchHistoryResult (
    @SerializedName("metadata")
    val metadata: Metadata,

    @SerializedName("info")
    val info: Info
) {
    class Metadata (
        @SerializedName("data_version")
        val dataVersion: String,

        @SerializedName("match_id")
        val matchId: String,

        @SerializedName("participants")
        val summonersPuuid: List<String>
    )

    class Info (
        @SerializedName("game_datetime")
        val gameDateTime: Long,

        @SerializedName("game_length")
        val gameLength: Double,

        @SerializedName("game_variation")
        val gameVariation: String,

        @SerializedName("game_version")
        val gameVersion: String,

        @SerializedName("participants")
        val participants: List<Participant>,

        @SerializedName("queue_id")
        val queueId: Int,

        @SerializedName("tft_set_number")
        val tftSetNumber: Int
    ) {
        fun getDateTime(): String? {
            return try {
                val sdf = SimpleDateFormat("yyyy/MM/dd")
                val netDate = Date(this.gameDateTime * 1000)
                sdf.format(netDate)
            } catch (e: Exception) {
                e.toString()
            }
        }
    }

    class Participant (
        @SerializedName("gold_left")
        val goldLeft: Int,

        @SerializedName("lastRound")
        val lastRound: Int,

        @SerializedName("level")
        val level: Int,

        @SerializedName("placement")
        val placement: Int,

        @SerializedName("players_eliminated")
        val playersEliminated: Int,

        @SerializedName("puuid")
        val puuid: String,

        @SerializedName("time_eliminated")
        val timeEliminated: Float,

        @SerializedName("total_damage_to_players")
        val totalDamage: Int,

        @SerializedName("traits")
        val traits: List<Trait>,

        @SerializedName("units")
        val units: List<Unit>
    )

    class Trait (
        @SerializedName("name")
        val traitName: String,

        @SerializedName("num_units")
        val numUnits: Int,

        @SerializedName("style")
        val style: Int,

        @SerializedName("tier_current")
        val currentTier: Int,

        @SerializedName("tier_total")
        val totalTier: Int
    )

    class Unit (
        @SerializedName("items")
        val items: List<Int>,

        @SerializedName("character_id")
        val characterId: String,

        @SerializedName("chosen")
        val chosen: String,

        @SerializedName("name")
        val name: String,

        @SerializedName("rarity")
        val rarity: Int,

        @SerializedName("tier")
        val tier: Int
    )
}