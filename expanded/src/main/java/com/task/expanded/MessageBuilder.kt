package com.task.expanded

import com.task.domain.usecase.GetTopDistanceSportUseCase

class MessageBuilder {
    fun get(result: GetTopDistanceSportUseCase.TopDistanceSportResult): String {
        return when (result) {
            is GetTopDistanceSportUseCase.TopDistanceSportResult.Single -> "The top sport by distance excluding eBikes is ${result.sport}."
            is GetTopDistanceSportUseCase.TopDistanceSportResult.Multiple -> "The top sports by distance excluding eBikes are ${
                result.sports.joinToString(
                    ", "
                )
            }."

            is GetTopDistanceSportUseCase.TopDistanceSportResult.Error -> result.cause.message

        }
    }
}
