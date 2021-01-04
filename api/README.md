# api

This sub-project explores the JShell *API* (as compared to the JShell *tool*: `jshell`).

I'm doing this in the hopes that I can integrate it into Intellij via an Intellij plugin or hack on the JShell integration
that already exists in the Intellij Platform.

## Design

This project is implemented in two sub-projects:

* `subject/`. This sub-project contains our "subject" code, meaning the code we want to experiment with via a JShell
  session. In a normal project, this would be our application and library code but in this project it is just a means to
  an end. 
* `runner/`. This sub-project contains the `public static void main` method to instantiate a JShell session and
  handle a custom event loop which continuously reads input and executes it in JShell. This sub-project is the is the
  interesting part of the project. In it, we explore the JShell APIs in the `jdk.jshell` package.

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
