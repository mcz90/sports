package com.task.domain

import com.task.domain.filterstrategy.FilterStrategy
import com.task.domain.usecase.GetTopDistanceSportUseCase
import com.task.model.Summary

object DomainModule {

    val filterStrategy: FilterStrategy<Summary> =
        FilterStrategy.ETouringBicycleExcludingStrategy

    val getTopDistanceSportUseCase: GetTopDistanceSportUseCase by lazy {
        GetTopDistanceSportUseCase()
    }
}