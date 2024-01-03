package com.task.expanded

import com.task.domain.DomainModule

object AppModule {

    val expandedSolution: ExpandedSolution by lazy {
        ExpandedSolution(
            useCase = DomainModule.getTopDistanceSportUseCase
        )
    }
    val messageBuilder: MessageBuilder by lazy {
        MessageBuilder()
    }
}