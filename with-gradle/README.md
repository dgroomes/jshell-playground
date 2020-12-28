# with-gradle

This sub-project showcases an idiomatic Gradle-based Java project that is extended with a custom Gradle plugin that helps
you run `jshell` with the project's source code and library dependencies.

## Instructions

* Use Java 15
* Build and run the program with `./gradlew run`
* Alternatively, load the program source code and library dependencies into a `jshell` session!
  1. Build the program and start a jshell session with `./jshell.sh`
     * Notice the generated file `build/runtime-dependencies.txt`. Thanks Gradle!
  1. Explore the code! Enter the following commands and pay attention to the jshell session output:
     * `import static dgroomes.BytesPrettyPrinter.humanReadable`
     * `humanReadable(1000)`
     * `humanReadable(1024)`
     * `humanReadable(2000)`
     * Altogether, it will look like this:
       ```
        ./jshell.sh
        
        BUILD SUCCESSFUL in 941ms
        6 actionable tasks: 6 executed
        |  Welcome to JShell -- Version 15.0.1
        |  For an introduction type: /help intro
        
        jshell> import static dgroomes.BytesPrettyPrinter.humanReadable
        
        jshell> humanReadable(1000)
        $2 ==> "less than 1 KiB"
        
        jshell> humanReadable(1024)
        $3 ==> "1 KiB"
        
        jshell> humanReadable(2000)
        $4 ==> "greater than 1 KiB"
        
        jshell>       
       ```


## WishList

General clean-ups, TODOs and things I wish to implement for this project:

* Define the "build" task depends-on relationship with "listDependencies" in the plugin code itself instead of the project
  Gradle file.

## Referenced material

* [Another project of mine: `gradle-playground`](https://github.com/dgroomes/gradle-playground/tree/main/plugin)
* [Gradle docs: *Developing Custom Gradle Plugins*](https://docs.gradle.org/current/userguide/custom_plugins.html)
* [Gradle docs: *Authoring Tasks*](https://docs.gradle.org/current/userguide/more_about_tasks.html)
  * [*Task outcomes*](https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:task_outcomes)
  * [*Up-to-date checks (AKA Incremental Builds)*](https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:up_to_date_checks)
