package com.task.expanded

import com.task.domain.DomainModule
import com.task.domain.error.SportError
import com.task.domain.usecase.GetTopDistanceSportUseCase.TopDistanceSportResult
import com.task.model.Sport
import com.task.model.Summary
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class ExpandedSolutionTest {
    private val solution = AppModule.expandedSolution
    private val filterStrategy = DomainModule.filterStrategy

    @Test
    fun `Finds the top sport in the list as TopDistanceSportResult Single`() {
        val input = listOf(
            Summary(Sport.HIKE, 92),
            Summary(Sport.RUN, 77),
            Summary(Sport.TOURING_BICYCLE, 322),
            Summary(Sport.E_TOURING_BICYCLE, 656)
        )
        val result = solution.getSummaries(input, filterStrategy)

        assertNotNull(result)
        assertTrue(result == TopDistanceSportResult.Single(Sport.TOURING_BICYCLE))
    }

    @Test
    fun `Finds the top sports in the list as TopDistanceSportResult Multiple`() {
        val input = listOf(
            Summary(Sport.HIKE, 92),
            Summary(Sport.RUN, 77),
            Summary(Sport.RUN, 322),
            Summary(Sport.TOURING_BICYCLE, 322),
            Summary(Sport.E_TOURING_BICYCLE, 656)
        )
        val result = solution.getSummaries(input, filterStrategy)

        assertNotNull(result)
        assertTrue(result == TopDistanceSportResult.Multiple(listOf(Sport.RUN, Sport.TOURING_BICYCLE)))
    }

    @Test
    fun `Returns EmptyInputError input list is empty`() {
        val input = emptyList<Summary>()
        val result = solution.getSummaries(input, filterStrategy)

        assertNotNull(result)
        assertTrue(result == TopDistanceSportResult.Error(SportError.EmptyInputError))
    }

    @Test
    fun `Returns EmptyResultError filtered list is empty`() {
        val input = listOf(
            Summary(Sport.E_TOURING_BICYCLE, 656)
        )

        val result = solution.getSummaries(input, filterStrategy)

        assertNotNull(result)
        assertTrue(result == TopDistanceSportResult.Error(SportError.EmptyResultError))
    }
}
