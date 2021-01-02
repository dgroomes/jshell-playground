# api

This sub-project explores the JShell *API* (as compared to the JShell tool: `jshell`).

I'm doing this in the hopes that I can integrate it into Intellij via an Intellji plugin or hack on the JShell integration
that already exists in the Intellij Platform.

## Instructions

* Build the program with `./gradlew installDist`
* Run it with `build/install/api/bin/api`
* Tip: for a conveniently fast "develop and run" experience try aliasing the build and run commands together:
  * `alias doit="./gradlew installDist && build/install/api/bin/api"`
  * `doit`
  * Make a code chage.
  * `doit`
  * Etc.

### Reference materials

* [Intellij bug: *JShell: "Use classpath of" doesn't work*](https://youtrack.jetbrains.com/issue/IDEA-176418)
* [JavaDoc for the "jdk.shell: module](https://docs.oracle.com/en/java/javase/15/docs/api/jdk.jshell/jdk/jshell/package-summary.html)
