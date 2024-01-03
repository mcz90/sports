package com.task.domain

import com.task.model.Summary

interface Solution {
    fun getSummaries(summaries: List<Summary>): List<Summary>?
}
