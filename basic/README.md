# basic

This sub-project shows how to start a `jshell` (the JShell command-line tool) session with your own application source code. It is beginner friendly!

### Instructions

Note: this project was developed on macOS.

1. Use Java 15
1. Execute `./build.sh` to compile the source code
1. Execute `./run-main.sh` to run the program (i.e. the `public static void main` method). But... this isn't what we are
   really interested in. We want to use JShell! See the next step.
1. Execute `./run-jshell.sh` to start a `jshell` session which loads the application source code
1. Explore!
    * For example, execute the `sayHello` method:
      * `dgroomes.MessageUtil.sayHello("me")`
    * Import the `sayHello` method:
      * `import static dgroomes.MessageUtil.sayHello`
    * Execute the `sayHello` method again but without the fully qualified name (thanks to the import):         
      * `sayHello("you")`
    * Altogether, it will look like this:
      ```
      ./build.sh
      ./run-jshell.sh
      |  Welcome to JShell -- Version 15.0.1
      |  For an introduction type: /help intro
      
      jshell> dgroomes.MessageUtil.sayHello("me")
      Hello,
      me!
      
      jshell> import static dgroomes.MessageUtil.sayHello
      
      jshell> sayHello("you")
      Hello,
      you!
      
      jshell>
      ```
