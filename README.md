# play-java-junit5-example

A PlayFramework sample showing how to use JUnit 5.

The problem mixes JUnit 4 & 5  tests to show that both [junit-interface](https://github.com/sbt/junit-interface) and [sbt-jupiter-interface](https://github.com/maichler/sbt-jupiter-interface) can be used at the same time.

## Running the tests

Use regular `test` task to run both tests for JUnit 4 & 5:

```bash
sbt test
```

You should then see something like:

```
...
[info] Test run started
[info] Test controllers.JUnit4HomeControllerTest.testIndex started
[info] Test run finished: 0 failed, 0 ignored, 1 total, 2.375s
[info] Test run started (JUnit Jupiter)
[info] Test controllers.JUnit5HomeControllerTest#testIndex() started
[info] Test run finished: 0 failed, 0 ignored, 1 total, 0.205s
[info] Passed: Total 2, Failed 0, Errors 0, Passed 2
...
```
