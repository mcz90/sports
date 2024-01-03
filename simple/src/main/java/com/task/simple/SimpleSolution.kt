package com.task.simple

import com.task.model.Sport
import com.task.model.Summary

class SimpleSolution {

    fun getResult(list: List<Summary>): Summary? {
        return list
            .filter { it.sport != Sport.E_TOURING_BICYCLE }
            .maxByOrNull { it.distance }
    }
}
