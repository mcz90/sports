package com.task.domain.filterstrategy

import com.task.model.Sport
import com.task.model.Summary

sealed interface FilterStrategy<T> {
    fun filter(list: List<T>): List<T>

    data object ETouringBicycleExcludingStrategy : FilterStrategy<Summary> {
        override fun filter(list: List<Summary>): List<Summary> {
            return list.filter { it.sport != Sport.E_TOURING_BICYCLE }
        }
    }
}

