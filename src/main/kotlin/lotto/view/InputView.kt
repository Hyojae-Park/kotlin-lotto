package lotto.view

import lotto.error.ErrorMessage.EMPTY_INPUT_MESSAGE
import lotto.error.ErrorMessage.EXPECT_NUMBER_MESSAGE

object InputView {

    fun inputMoney(): Int {
        try {
            return readln().toInt()
        } catch (e: NullPointerException) {
            throw IllegalArgumentException(EMPTY_INPUT_MESSAGE.message)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(EXPECT_NUMBER_MESSAGE.message)
        }
    }

    fun inputJackpotNumber(): String {
        val jackpotNumber = readlnOrNull()
        require(!jackpotNumber.isNullOrEmpty()) { EMPTY_INPUT_MESSAGE.message }

        return jackpotNumber
    }

    fun inputBonusNumber(): Int {
        try {
            return readln().toInt()
        } catch (e: NullPointerException) {
            throw IllegalArgumentException(EMPTY_INPUT_MESSAGE.message)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(EXPECT_NUMBER_MESSAGE.message)
        }
    }

    fun inputManualLottoBuyCount(): Int {
        try {
            return readln().toInt()
        } catch (e: NullPointerException) {
            throw IllegalArgumentException(EMPTY_INPUT_MESSAGE.message)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(EXPECT_NUMBER_MESSAGE.message)
        }
    }

    fun inputManualLottoNumbers(): String {
        val manualLottoNumber = readln()
        require(manualLottoNumber.isNotEmpty()) { EMPTY_INPUT_MESSAGE.message }

        return manualLottoNumber
    }
}
