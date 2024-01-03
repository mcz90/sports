package com.task.domain.usecase

import com.task.domain.error.SportError
import com.task.domain.filterstrategy.FilterStrategy
import com.task.model.Sport
import com.task.model.Summary


class GetTopDistanceSportUseCase {

    fun execute(
        summaries: List<Summary>,
        filterStrategy: FilterStrategy<Summary>
    ): TopDistanceSportResult {
        if (summaries.isEmpty()) {
            return TopDistanceSportResult.Error(SportError.EmptyInputError)
        }

        val result = getTopDistanceSummaries(summaries, filterStrategy)
        if (result.isNullOrEmpty()) {
            return TopDistanceSportResult.Error(SportError.EmptyResultError)
        }

        val sports = result.map { it.sport }
        return when {
            sports.size > 1 -> TopDistanceSportResult.Multiple(sports)
            else -> TopDistanceSportResult.Single(sports.first())
        }
    }


    private fun getTopDistanceSummaries(
        summaries: List<Summary>,
        filterStrategy: FilterStrategy<Summary>
    ): List<Summary>? {
        val filteredSummaries = filterStrategy.filter(summaries)
        val biggestDistance = filteredSummaries.maxByOrNull { it.distance }?.distance

        return biggestDistance
            ?.let { getBiggestDistanceSummaries(summaries, biggestDistance) }
    }

    private fun getBiggestDistanceSummaries(
        filteredSummaries: List<Summary>,
        biggestDistance: Int
    ): List<Summary> {
        return filteredSummaries.filter { summary ->
            summary.distance == biggestDistance
        }
    }


    sealed class TopDistanceSportResult {
        data class Single(val sport: Sport) : TopDistanceSportResult()
        data class Multiple(val sports: List<Sport>) : TopDistanceSportResult()
        data class Error(val cause: SportError) : TopDistanceSportResult()
    }
}

