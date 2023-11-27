package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGameResultTest {

    @Test
    fun `수익률 계산이 올바르게 수행된다`() {
        val lottoes = Lottoes(
            listOf(
                Lotto(LottoNumbers.get(1, 2, 3, 10, 20, 30)),
                Lotto(LottoNumbers.get(1, 2, 3, 4, 20, 30)),
                Lotto(LottoNumbers.get(40, 41, 42, 43, 44, 45))
            )
        )
        val winningLotto = Lotto(LottoNumbers.get(1, 2, 3, 4, 5, 6))
        val purchaseAmount = 3000
        val bonusNumber = LottoNumber(9)

        val result = LottoGameResult.getResult(
            BuyingLottoes(BuyingAutoLottoes(lottoes), BuyingManualLottoes(Lottoes(emptyList()))),
            winningLotto,
            bonusNumber
        )
        val expectedEarningsRate = (5000 + 50000).toDouble() / purchaseAmount

        assertEquals(expectedEarningsRate, result.earningsRate)
    }

    @Test
    fun `올바른 로또 번호 일치 횟수를 반환한다`() {
        val lottoes = Lottoes(
            listOf(
                Lotto(LottoNumbers.get(1, 2, 3, 10, 20, 30)),
                Lotto(LottoNumbers.get(1, 2, 3, 4, 20, 30)),
                Lotto(LottoNumbers.get(40, 41, 42, 43, 44, 45))
            )
        )
        val winningLotto = Lotto(LottoNumbers.get(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber(9)

        val result = LottoGameResult.getResult(
            BuyingLottoes(BuyingAutoLottoes(lottoes), BuyingManualLottoes(Lottoes(emptyList()))),
            winningLotto,
            bonusNumber
        )
        val expectedStatistics = mapOf(
            PrizeGrade.GRADE_5 to 1,
            PrizeGrade.GRADE_4 to 1,
            PrizeGrade.GRADE_3 to 0,
            PrizeGrade.GRADE_2 to 0,
            PrizeGrade.GRADE_1 to 0
        )

        assertEquals(expectedStatistics, result.statistics)
    }
}
