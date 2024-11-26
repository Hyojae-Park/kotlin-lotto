package lotto.step2.domain

interface NumberPicker {
    fun pick(): List<Int>

    val candidates: List<Int>
        get() = (1..45).toList()
}
