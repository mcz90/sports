package com.task.domain.error

sealed class SportError(val message: String) {
    data object EmptyInputError : SportError("The summaries input list can not be empty empty.")
    data object EmptyResultError : SportError("The summaries list were empty and could not get the top sport")
}