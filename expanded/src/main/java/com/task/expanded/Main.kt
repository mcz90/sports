package com.task.expanded

import com.task.domain.DomainModule
import com.task.model.Sport
import com.task.model.Summary

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sportStats = listOf(
                Summary(Sport.HIKE, 92),
                Summary(Sport.RUN, 77),
                Summary(Sport.TOURING_BICYCLE, 322),
                Summary(Sport.E_TOURING_BICYCLE, 656)
            )
            val filterStrategy = DomainModule.filterStrategy
            val expandedSolution = AppModule.expandedSolution
            val result = expandedSolution.getSummaries(sportStats, filterStrategy)
            val message = AppModule.messageBuilder.get(result)

            println(message)
        }
    }
}

