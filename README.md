# jshell-playground

📚 Learning and exploring JShell—the official Java shell and read-eval-print loop (REPL).

---

Java is infamously awkward to get up and running with for beginner programmers. `public static void main(String[] args)`... really?
And the `main` method must be wrapped in a class. And the compile and run steps must be in separate commands (until [JEP-330](https://openjdk.java.net/jeps/330) anyway).
Overall, a prototypical "hello world" program is just too hard compared to other languages.
 
🚀 JShell to the rescue!

JShell removes all of those requirements and enables a beginner programmer to start learning and exploring Java
without all the fuss! Start with the `basic/` sub-project.

### Learn about JShell

The JDK Enhancement Proposal that introduced JShell is the best place to learn the "what" and "why" about it: <http://openjdk.java.net/jeps/222>.

To learn the "how", see the [*Introduction to JShell* article](https://docs.oracle.com/en/java/javase/14/jshell/introduction-jshell.html#GUID-630F27C8-1195-4989-9F6B-2C51D46F52C8).

Some highlights from the JEP page include:

> Provide an interactive tool to evaluate declarations, statements, and expressions of the Java programming language, together with an API so that other applications can leverage this functionality.

> Out of scope are graphical interfaces and debugger support. The JShell API is intended to allow JShell functionality in IDEs and other tools, but the jshell tool is not intended to be an IDE.

> Immediate feedback is important when learning a programming language and its APIs. The number one reason schools cite for moving away from Java as a teaching language is that other languages have a "REPL" and have far lower bars to an initial "Hello, world!" program.

> Exploration of coding options is also important for developers prototyping code or investigating a new API. Interactive evaluation is vastly more efficient in this regard than edit/compile/execute and System.out.println.

## Standalone sub-projects

This repository illustrates different concepts, patterns and examples via standalone sub-projects. Each sub-project is
completely independent of the others and do not depend on the root project. This _standalone sub-project constraint_
forces the sub-projects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The sub-projects include:

### `basic/`

This sub-project shows how to start a `jshell` (the JShell command-line tool) session with your own application source code. It is beginner friendly!

See the README in [basic/](basic/).

### `with-libraries`

This sub-project is similar to `basic/` buts adds a few external Java libraries (including [Jackson](https://github.com/FasterXML/jackson)).

See the README in [with-libraries/](with-libraries/).

### `with-gradle`

This sub-project showcases an idiomatic Gradle-based Java project that is extended with a custom Gradle plugin that helps
you run a `jshell` session with the project's source code and library dependencies.

See the README in [with-gradle/](with-gradle/).

## WishList

General clean-ups, TODOs and things I wish to implement for this project:

* DONE Implement `basic/`
* SKIPPED (no, not possible) Can we execute `jshell` without compiling the program source code? Similar to the single-file source code support?
* DONE Implement `with-gradle/`. It should be taken directly from <https://github.com/dgroomes/gradle-playground/tree/main/plugin>.
* Can the `basic` and `with-libraries` sub-projects be define as Gradle "included builds"? To be clerr, they are not
  Gradle projects but to get the convenience of "Clone a repo and open it in the IDE" I want to technically define them
  as Gradle projects using the root `build.gradle.kts` (does not exist yet). I'm not sure how to re-defined the path to the
  "source sets" (i.e `src/` instead of the traditional Maven/Gradle `src/main/java/`).
* DONE (well, not perfectly) Use the name "JShell" where appropriate instead of `jshell`
