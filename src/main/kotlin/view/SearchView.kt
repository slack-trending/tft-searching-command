package view

import com.slack.api.model.block.Blocks.asBlocks
import com.slack.api.model.block.Blocks.section
import com.slack.api.model.block.composition.BlockCompositions.markdownText
import util.api.dto.SummonerInfoResult

class SearchView {
    fun buildSummonerInfo(userInfo: SummonerInfoResult) = asBlocks (
        section { section -> section
            .text(markdownText("소환사 이름: " + userInfo.name))
            .text(markdownText("소환사 레벨: " + userInfo.summonerLevel))
        }
    )
}