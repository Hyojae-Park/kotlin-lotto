package lotto.domain

import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `로또 티켓을 한장 생성한다`() {
        val ticket = LottoTicket(1, 2, 3, 4, 5, 6)
        ticket.equals(listOf(1, 2, 3, 4, 5, 6)).shouldBeTrue()
    }

    @Test
    fun `로또 티켓을 한장 랜덤 생성한다`() {
        val tickets = LottoTicket.generateLottoTickets(1)
        println(tickets)
        tickets.size shouldBe 1
    }

    @Test
    fun `1등 확인`() {
        val ticket = LottoTicket(1, 2, 3, 4, 5, 6)
        val winner = LottoTicket(1, 2, 3, 4, 5, 6)
        println("$ticket, $winner")
        winner.correctNumberCount(ticket) shouldBe 6
    }

    @Test
    fun `3등 확인`() {
        val ticket = LottoTicket(1, 2, 3, 4, 7, 8)
        val winner = LottoTicket(1, 2, 3, 4, 5, 6)
        println("$ticket, $winner")
        winner.correctNumberCount(ticket) shouldBe 4
    }
}
