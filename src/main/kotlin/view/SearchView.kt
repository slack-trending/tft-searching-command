package view

import com.slack.api.model.block.Blocks.section
import com.slack.api.model.block.LayoutBlock
import com.slack.api.model.block.composition.BlockCompositions.markdownText
import util.api.dto.MatchHistoryResult

class SearchView {
    fun buildMatchHistories(matchHistories: List<MatchHistoryResult>): List<LayoutBlock> =
        matchHistories.map { match ->
            section { section -> section
                .text(markdownText("게임한 날짜: ${match.info.gameDateTime}, 게임한 시간: ${match.info.gameLength}"))
            }
        }
}