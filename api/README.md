# api

This sub-project explores the JShell *API* (as compared to the JShell tool: `jshell`).

I'm doing this in the hopes that I can integrate it into Intellij via an Intellji plugin or hack on the JShell integration
that already exists in the Intellij Platform.

## Design

This project is implemented in two sub-projects:

* `runner/`. This sub-project contains the `public static void main` method to instantiate a JShell session and handle
  the main event loop: 1) read input 2) execute
* `subject/`. This sub-project contains our "subject" code, meaning the code we want to experiment with. In a normal
  project, this would be our application and library code. NOT YET IMPLEMENTED  

This gets a little confusing because there are so many Java processes (and likewise so many Java class paths) flying around
in the mix:

1. The Java process that runs Gradle
1. The Java process that runs `runner/`
1. The Java process that is created for the JShell process by `runner/`

## Instructions

* Build the `subject/` project with `./gradlew subject:installDist`
* Build the `runner/` program with `./gradlew runner:installDist`
* Run it with `runner/build/install/runner/bin/runner`
* Tip: for a conveniently fast "develop and run" experience try aliasing the build and run commands together:
  * `alias doit="./gradlew subject:installDist runner:installDist && runner/build/install/runner/bin/runner"`
  * `doit`
  * Make a code change.
  * `doit`
  * Etc.

### Reference materials

* [Intellij bug: *JShell: "Use classpath of" doesn't work*](https://youtrack.jetbrains.com/issue/IDEA-176418)
* [JavaDoc for the "jdk.shell: module](https://docs.oracle.com/en/java/javase/15/docs/api/jdk.jshell/jdk/jshell/package-summary.html)
