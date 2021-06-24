package handler

import com.slack.api.bolt.context.builtin.SlashCommandContext
import com.slack.api.bolt.request.builtin.SlashCommandRequest
import com.slack.api.bolt.response.Response
import com.slack.api.bolt.response.ResponseTypes
import usecase.user.search.SearchUsecase
import util.logger.Logger
import view.SearchView

const val BASE_URL = "https://kr.api.riotgames.com/"

class TFTHandler {

    companion object: Logger

    private val searchUsecase = SearchUsecase(BASE_URL)
    private val searchView = SearchView()

    fun search(req: SlashCommandRequest, ctx: SlashCommandContext): Response {
        val userInfo = searchUsecase.searchByUserName(req.payload.text)

        ctx.respond { res -> res
            .responseType(ResponseTypes.inChannel)
            .blocks(searchView.buildSummonerInfo(userInfo))}

        return ctx.ack()
    }
}