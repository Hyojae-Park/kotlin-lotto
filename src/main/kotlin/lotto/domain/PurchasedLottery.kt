package lotto.domain

class PurchasedLottery(
    private val manualLottery: Lottery,
    private val autoLottery: Lottery,
) {
    fun getManualCount(): Int = manualLottery.getCount()
    fun getAutoCount(): Int = autoLottery.getCount()

    fun getLottery(): Lottery = Lottery(manualLottery.lottoList + autoLottery.lottoList)
}
