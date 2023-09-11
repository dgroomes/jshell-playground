# with-gradle

This subproject showcases an idiomatic Gradle-based Java project that is extended with a custom Gradle plugin that helps
you run a `jshell` session with the project's source code and library dependencies.


## Instructions

Follow these instructions to build the program distribution and run `jshell`.

1. Use Java 17
2. Build and run the program
   * ```shell
     ./gradlew run
     ```
   * But... this isn't what we are really interested in. We want to use
     JShell! See the next steps where we load the program source code and library dependencies into a `jshell` session.
3. Build the program distribution and start a `jshell` session with the program source code and library dependencies
   * ```shell
     ./build-and-run-in-jshell.sh
     ```
   * Notice the generated file `build/runtime-dependencies.txt`. Thanks, Gradle!
4. Explore!
   * For example, execute an `import` statement in the `jshell` session.
     * `import static dgroomes.BytesPrettyPrinter.humanReadable`
   * Then try out the `humanReadable` method:
     * `humanReadable(1000)`
     * Pay close attention to the output in your `jshell` session! 
   * Try passing a different value:
     * `humanReadable(1024)`
   * Try yet another value:
     * `humanReadable(2000)`
   * When you're done, exit the `jshell` session with `/exit`
   * Altogether, it will look like this:
     ```text
      ./build-and-run-in-jshell.sh
      
      BUILD SUCCESSFUL in 941ms
      6 actionable tasks: 6 executed
      |  Welcome to JShell -- Version 17.0.7
      |  For an introduction type: /help intro
      
      jshell> import static dgroomes.BytesPrettyPrinter.humanReadable
      
      jshell> humanReadable(1000)
      $2 ==> "less than 1 KiB"
      
      jshell> humanReadable(1024)
      $3 ==> "1 KiB"
      
      jshell> humanReadable(2000)
      $4 ==> "greater than 1 KiB"
      
      jshell> /exit
      |  Goodbye
      ```


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Define the "build" task depends-on relationship with "listDependencies" in the plugin code itself instead of the project
  Gradle file.


## Reference

* [Another project of mine: `gradle-playground`](https://github.com/dgroomes/gradle-playground/tree/main/plugin)
* [Gradle docs: *Developing Custom Gradle Plugins*](https://docs.gradle.org/current/userguide/custom_plugins.html)
* [Gradle docs: *Authoring Tasks*](https://docs.gradle.org/current/userguide/more_about_tasks.html)
  * [*Task outcomes*](https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:task_outcomes)
  * [*Up-to-date checks (AKA Incremental Builds)*](https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:up_to_date_checks)
