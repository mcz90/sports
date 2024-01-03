package com.task.simple

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
            val simpleSolution = SimpleSolution()
            val result = simpleSolution.getResult(sportStats)
            val message = if (result != null) {
                "The top sport by distance excluding eBikes ${result.sport}."
            } else {
                "Something went wrong."
            }
            println(message)
        }
    }
}