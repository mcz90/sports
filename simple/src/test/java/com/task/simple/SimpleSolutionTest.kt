package com.task.simple

import com.task.model.Sport
import com.task.model.Summary
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SimpleSolutionTest {

    @Test
    fun `Finds the top sport in the list`() {
        val solution = SimpleSolution()

        val input = listOf(
            Summary(Sport.HIKE, 92),
            Summary(Sport.RUN, 77),
            Summary(Sport.TOURING_BICYCLE, 322),
            Summary(Sport.E_TOURING_BICYCLE, 656)
        )
        val result = solution.getResult(input)

        assertNotNull(result)
        assertTrue(result!!.sport == Sport.TOURING_BICYCLE)
    }

    @Test
    fun `Returns null from empty result list`() {
        val solution = SimpleSolution()
        val input = listOf(
            Summary(Sport.E_TOURING_BICYCLE, 656)
        )
        val result = solution.getResult(input)
        assertNull(result)
    }

    @Test
    fun `Returns null from empty input list`() {
        val solution = SimpleSolution()

        val input = emptyList<Summary>()
        val result: Summary? = solution.getResult(input)

        assertNull(result)
    }

    @Test
    fun `Returns first element when more than one top sport is present`() {
        val solution = SimpleSolution()
        val input = listOf(
            Summary(Sport.HIKE, 92),
            Summary(Sport.RUN, 77),
            Summary(Sport.RUN, 322),
            Summary(Sport.TOURING_BICYCLE, 322),
            Summary(Sport.E_TOURING_BICYCLE, 656)
        )
        val result: Summary? = solution.getResult(input)
        assertTrue(result == Summary(Sport.RUN, 322))
    }
}