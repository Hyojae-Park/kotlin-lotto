package study.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `Lotto 생성 시 번호가 6개가 아니면 예외를 발생시킨다`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val invalidNumbers = LottoNumbers.get(1, 2, 3, 4, 5)
            Lotto(invalidNumbers)
        }

        assertTrue(exception.message!!.contains("LottoNumbers size must be equal to 6"))
    }

    @Test
    fun `Lotto 생성 시 번호가 올바르면 Lotto 객체를 반환한다`() {
        val validNumbers = LottoNumbers.get(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(validNumbers)
        assertThat(lotto.numbers).isEqualTo(validNumbers)
    }

    @Test
    fun `당첨 번호와 일치하는 번호의 등급을 올바르게 계산한다`() {
        val bonusNumber = LottoNumber(10)
        val lotto = Lotto(LottoNumbers.get(1, 2, 3, 4, 5, 6))
        val winningNumbers = Lotto(LottoNumbers.get(4, 5, 6, 7, 8, 9))
        assertEquals(PrizeGrade.GRADE_5, lotto.getPrizeGrade(winningNumbers, bonusNumber))
    }
}
