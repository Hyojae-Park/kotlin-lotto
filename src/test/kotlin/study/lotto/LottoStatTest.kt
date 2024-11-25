package study.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.lotto.model.Lotto
import study.lotto.model.LottoPrize
import study.lotto.model.LottoStat

/**
 * @author 이상준
 */
class LottoStatTest : StringSpec({
    "Lotto Stat Count 증가 테스트" {
        val lottoStat = LottoStat(LottoPrize.FIRST)
        lottoStat.addCount()

        lottoStat.count shouldBe 1
    }
    "Lotto Stat Count 2 증가 테스트" {
        val lottoStat = LottoStat(LottoPrize.FIRST)
        lottoStat.addCount()
        lottoStat.addCount()

        lottoStat.count shouldBe 2
    }

})
