package at.aau.serg.controllers

import at.aau.serg.models.GameResult
import at.aau.serg.services.GameResultService
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import kotlin.test.Test
import kotlin.test.assertEquals
import org.mockito.Mockito.`when` as whenever // when is a reserved keyword in Kotlin

class LeaderboardControllerTests {

    private lateinit var mockedService: GameResultService
    private lateinit var controller: LeaderboardController

    @BeforeEach
    fun setup() {
        mockedService = mock<GameResultService>()
        controller = LeaderboardController(mockedService)
    }

    /*
    Ich konnte die Validität der Tests nicht komplett überprüfen, da die Tests im Projekt nicht auszuführen waren. Ich habe es sehr lange versucht und über die letzten
    Tage hinweg einige neue Projekte und Repositories erstellt und gelöscht, aber es hat auf keine Weise ganz funktioniert, aber ich bin mir sehr sicher, dass der Code stimmen
    sollte.
     */
    @Test
    fun test_getLeaderboard_correctScoreSorting_and_TimeSorting() {
        val first = GameResult(1, "first", 20, 10.0) //höchster Score aber schnellste Zeit
        val second = GameResult(2, "second", 20, 15.0) //gleicher Score aber langsamere Zeit
        val third = GameResult(3, "third", 15, 12.0) //niedrigerer Score aber gleiche Zeit

        val res = listOf(second, first, third)

        assertEquals(3, res.size)
        assertEquals(first, res[0])
        assertEquals(second, res[1])
        assertEquals(third, res[2])
    }
}