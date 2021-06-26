package view

import com.slack.api.model.block.Blocks.asBlocks
import com.slack.api.model.block.Blocks.section
import com.slack.api.model.block.LayoutBlock
import com.slack.api.model.block.composition.BlockCompositions.markdownText
import util.api.dto.MatchHistoryResult

class SearchView {
    fun buildMatchHistories(matchHistories: List<MatchHistoryResult>): MutableList<LayoutBlock> = asBlocks (
        section { section -> section
            .text(markdownText("게임 시간: ${matchHistories[0].info.gameDateTime}, 게임 정보: ${matchHistories[0].info.participants[0].level}"))
        }
    )
}