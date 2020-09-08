# jshell-playground

📚 Learning and exploring `jshell`—the official Java shell and read-eval-print loop (REPL).

---

Java is infamously awkward to get up and running with for beginner programmers. `public static void main(String[] args)`... really?
And the `main` method must be wrapped in a class. And the compile and run steps must be in separate commands (until [JEP-330](https://openjdk.java.net/jeps/330) anyway).
Overall, a prototypical "hello world" program is just too hard compared to other languages.
 
🚀 `jshell` to the rescue!

This project showcases a simple setup for using `jshell` with a few libraries (including [Jackson](https://github.com/FasterXML/jackson))
and with a small set of application source code files. `jshell` is awesome!

### Learn about `jshell`

The JDK Enhancement Proposal that introduced `jshell` is the best place to learn the "what" and "why" about it: <http://openjdk.java.net/jeps/222>.

To learn the "how", see <https://docs.oracle.com/en/java/javase/14/jshell/introduction-jshell.html#GUID-630F27C8-1195-4989-9F6B-2C51D46F52C8>.

Some highlights from the JEP page include:

> Provide an interactive tool to evaluate declarations, statements, and expressions of the Java programming language, together with an API so that other applications can leverage this functionality.

> Out of scope are graphical interfaces and debugger support. The JShell API is intended to allow JShell functionality in IDEs and other tools, but the jshell tool is not intended to be an IDE.

> Immediate feedback is important when learning a programming language and its APIs. The number one reason schools cite for moving away from Java as a teaching language is that other languages have a "REPL" and have far lower bars to an initial "Hello, world!" program.

> Exploration of coding options is also important for developers prototyping code or investigating a new API. Interactive evaluation is vastly more efficient in this regard than edit/compile/execute and System.out.println.

### Instructions

NOTE: this was developed on macOS.

1. Use Java 14
1. Execute `./build.sh` to compile the source code 
1. Execute `./run-main.sh` to run the program (i.e. the `main` method). But... this isn't what we really want. We want
   to use `jshell`! See the next step.
1. Execute `./run-jshell.sh` to start a `jshell` session which loads the library and application source code
1. The `jshell` session will be pre-loaded with some convenience imports so you can get busy experimenting with `ObjectMapper`
   and the custom classes `PointPojo` and `PointRecord`. For example, see a screenshot of an interactive session below:
![jshell example interactive session](example-session.png)   
