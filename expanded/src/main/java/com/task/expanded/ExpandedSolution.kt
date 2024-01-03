package com.task.expanded

import com.task.domain.filterstrategy.FilterStrategy
import com.task.domain.usecase.GetTopDistanceSportUseCase
import com.task.domain.usecase.GetTopDistanceSportUseCase.TopDistanceSportResult
import com.task.model.Summary

class ExpandedSolution(
    private val useCase: GetTopDistanceSportUseCase
) {

    fun getSummaries(
        summaries: List<Summary>,
        filterStrategy: FilterStrategy<Summary>
    ): TopDistanceSportResult {
        return useCase.execute(summaries, filterStrategy)
    }
}
