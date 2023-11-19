package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.number.LottoNumber
import lotto.domain.number.LottoNumberResult

class LottoTest : StringSpec({

    "로또 번호가 6개가 아니면 실패를 반환한다." {
        listOf(0, 1, 2, 3, 4, 5).forEach { count ->
            // given
            val numbers = List(count) { 1 }

            // when
            val lottoResult = Lotto.createFromNumbers(numbers)

            // then
            lottoResult shouldBe LottoResult.Failure("로또 번호는 6개여야 합니다.")
        }
    }

    "로또 번호가 중복이면 실패를 반환한다." {
        // given
        val numbers = listOf(1, 1, 2, 3, 4, 5)

        // when
        val lottoResult = Lotto.createFromNumbers(numbers)

        // then
        lottoResult shouldBe LottoResult.Failure("로또 번호는 중복되지 않아야 합니다.")
    }

    "두 로또 번호 사이의 중복된 개수를 구한다." {
        // given
        val lottoResult = Lotto.createFromNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotto = lottoResult as LottoResult.Success

        val otherLottoResult = Lotto.createFromNumbers(listOf(2, 5, 6, 7, 8, 10))
        val otherLotto = otherLottoResult as LottoResult.Success

        val bonusBallResult = LottoNumber.createResult(11)
        val bonusBall = bonusBallResult as LottoNumberResult.Success

        val winningLottoResult = WinningLotto.createResult(otherLotto.data, bonusBall.data)
        val winningLotto = winningLottoResult as WinningLottoResult.Success

        val hasBonusBall = false

        // when
        val count = lotto.data.calculateMatchCount(winningLotto.data, hasBonusBall)

        // then
        count shouldBe 3
    }

    "두 로또 번호 사이의 중복된 개수를 구할 때 보너스 볼이 존재하지만, 중복된 개수가 5라면 1을 추가하지 않는다." {
        // given
        val lottoResult = Lotto.createFromNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotto = lottoResult as LottoResult.Success

        val otherLottoResult = Lotto.createFromNumbers(listOf(2, 3, 4, 5, 6, 10))
        val otherLotto = otherLottoResult as LottoResult.Success

        val bonusBallResult = LottoNumber.createResult(1)
        val bonusBall = bonusBallResult as LottoNumberResult.Success

        val winningLottoResult = WinningLotto.createResult(otherLotto.data, bonusBall.data)
        val winningLotto = winningLottoResult as WinningLottoResult.Success
        val hasBonusBall = true

        // when
        val count = lotto.data.calculateMatchCount(winningLotto.data, hasBonusBall)

        // then
        count shouldBe 5
    }

    "두 로또 번호 사이의 중복된 개수를 구할 때 보너스 볼이 존재하면서, 중복된 개수가 5가 아니라면 1 추가한 값을 반환한다." {
        forAll(
            row(listOf(1, 2, 3, 4, 7, 8), 5),
            row(listOf(1, 2, 3, 7, 8, 9), 4),
            row(listOf(1, 2, 7, 8, 9, 10), 3),
            row(listOf(1, 7, 8, 9, 10, 11), 2),
            row(listOf(7, 8, 9, 10, 11, 12), 1)
        ) { other, expected ->

            // given
            val lottoResult = Lotto.createFromNumbers(listOf(1, 2, 3, 4, 5, 6))
            val lotto = lottoResult as LottoResult.Success

            val otherLottoResult = Lotto.createFromNumbers(other)
            val otherLotto = otherLottoResult as LottoResult.Success

            val lottoNumberResult = LottoNumber.createResult(5)
            val bonusBall = lottoNumberResult as LottoNumberResult.Success

            val winningLottoResult = WinningLotto.createResult(otherLotto.data, bonusBall.data)
            val winningLotto = winningLottoResult as WinningLottoResult.Success
            val hasBonusBall = true

            // when
            val actual = lotto.data.calculateMatchCount(winningLotto.data, hasBonusBall)

            // then
            actual shouldBe expected
        }
    }

    "보너스 볼을 가지고 있으면 true, 아니면 false를 반환한다." {
        forAll(
            row(3, true),
            row(7, false)
        ) { number, expected ->
            // given
            val lottoResult = Lotto.createFromNumbers(listOf(1, 2, 3, 4, 5, 6))
            val lotto = lottoResult as LottoResult.Success

            val lottoNumberResult = LottoNumber.createResult(number)
            val bonusBall = lottoNumberResult as LottoNumberResult.Success

            // when
            val actual = lotto.data.hasBonusBall(bonusBall.data)

            // then
            actual shouldBe expected
        }
    }
})
