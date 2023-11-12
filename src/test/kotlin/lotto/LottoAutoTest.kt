package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.lotto.Lotto
import lotto.lotto.LottoNumbers
import lotto.lotto.LottoPrize
import lotto.lotto.auto.LottoAuto
import lotto.lotto.toWinningLotto

class LottoAutoTest : StringSpec({
    "구매한 로또 총 당첨 금액이 맞는지" {
        // 로또 당첨 금액 (1) - 0원   (2) - 50000원
        val input =
            listOf(Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6))), Lotto(LottoNumbers(listOf(2, 4, 6, 8, 12, 15))))
        val bonusBallNumber = 33
        val winningLotto = listOf(3, 6, 9, 12, 15, 18).toWinningLotto(bonusBallNumber)
        val expected = 5000
        val matchedList = LottoAuto.matchedLottoCountWithBonusBall(input, winningLotto)

        LottoAuto.sumOfWonLottoList(matchedList) shouldBe expected
    }

    "matchCountList 함수가 맞은 개수의 리스트를 잘 생산하는지 (1,2,3등을 맞추면 1,2,3등만 맞춘 리스트를 생성 4,5등은 생성x)" {
        val input = listOf(
            Lotto(LottoNumbers(listOf(1, 2, 3, 30, 31, 32))),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 30, 31))),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 45))),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)))
        )
        val bonusBallNumber = 45
        val winningLotto = listOf(1, 2, 3, 4, 5, 6).toWinningLotto(bonusBallNumber)
        // 순서대로 3,4,5,6개 맞아서 리스트에 LottoPrize와 함께 1,1,1,1가 저장됨
        val expected = mapOf(
            LottoPrize.FIFTH_PRIZE to 1,
            LottoPrize.FOURTH_PRIZE to 1,
            LottoPrize.SECOND_PRIZE to 1,
            LottoPrize.FIRST_PRIZE to 1
        )
        val eachLottoMatchCount = LottoAuto.matchedLottoCountWithBonusBall(input, winningLotto)
        val matchedList =
            eachLottoMatchCount.map { LottoPrize.getLottoPrize(it.lottoPrize.matchCount, it.bonusBallMatched) }

        LottoAuto.matchCountList(matchedList) shouldBe expected
    }

    "구매 금액 대비 당첨 금액의 비율이 맞는지" {
        val input = listOf(
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6))),
            Lotto(LottoNumbers(listOf(7, 8, 9, 10, 11, 12))),
            Lotto(LottoNumbers(listOf(13, 14, 15, 16, 17, 18))),
            Lotto(LottoNumbers(listOf(19, 20, 21, 22, 23, 24))),
            Lotto(LottoNumbers(listOf(25, 26, 27, 28, 29, 30)))
        )
        // 5개 샀고, 1번 로또가 4개 당첨 되어 5 만원
        val bonusBallNumber = 45
        val winningLotto = listOf(1, 2, 3, 4, 31, 32).toWinningLotto(bonusBallNumber)
        val inputAmount = 5000
        val matchedList = LottoAuto.matchedLottoCountWithBonusBall(input, winningLotto)
        val resultSum = LottoAuto.sumOfWonLottoList(matchedList)

        val expected = resultSum.toFloat() / inputAmount.toFloat()

        LottoAuto.earningRate(resultSum, inputAmount) shouldBe expected
    }
})
