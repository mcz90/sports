For the given GIST, there were 2 solutions provided:

## Simple solution

Right away implementation of the given task. Implemented in [SimpleSolution.kt]
As the given task is not described in details, the following assumptions were made:

- only first sport from result of given requirements will be returned, even if there are more elements that meets the
  requirements
- null value of the result is considered a generic error

In order to build and run the simple solution, run following gradle task from the console:
```
./gradlew :simple:build
./gradlew :simple:run
```

## Expanded solution
I decided to handle some corner cases in separated solution as the simple Kotlin program. Implemented in [ExpandedSolution.kt].
This might be considered as overengineering, but the reason for this solution is to show the elements of clean code, SOLID principles and the use of the Kotlin language to a greater extent.
Additionally I wanted to show the simplified way of writing the code that follows clean code principles, modularization and  

### Handled cases
- single sport
- multiple sports with the same distance
- empty input list
- empty filtered list

### Description
Simple service locators were provided to avoid objects instantiating boilerplate - [AppModule.kt], [DomainModule.kt]
The business logic itself was implemented in [GetTopDistanceSportUseCase.kt] that includes [FilterStrategy.kt].
Using the [FilterStrategy.kt] as separated object provides easy way to control the filtering login from outside the class.
The result is represented by TopDistanceSportResult sealed class, that improves readability and separates the result data representation.

In order to build and run the expanded solution, run following gradle task from the console:
```
./gradlew :expanded:build
./gradlew :expanded:run
```

### Tests
Base tests for the given solutions are provided, run following commands to run tests:
```
./gradlew test
```

[FilterStrategy.kt]: <https://github.com/mcz90/sports/blob/master/domain/src/main/java/com/task/domain/filterstrategy/FilterStrategy.kt>
[AppModule.kt]: <https://github.com/mcz90/sports/blob/master/expanded/src/main/java/com/task/expanded/AppModule.kt>
[DomainModule.kt]: <https://github.com/mcz90/sports/blob/master/domain/src/main/java/com/task/domain/DomainModule.kt>
[GetTopDistanceSportUseCase.kt]: <https://github.com/mcz90/sports/blob/master/domain/src/main/java/com/task/domain/usecase/GetTopDistanceSportUseCase.kt>
[ExpandedSolution.kt]: <https://github.com/mcz90/sports/blob/master/expanded/src/main/java/com/task/expanded/ExpandedSolution.kt>
[SimpleSolution.kt]: <https://github.com/mcz90/sports/blob/master/simple/src/main/java/com/task/simple/SimpleSolution.kt>
