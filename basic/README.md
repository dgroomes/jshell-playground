# basic

Start a `jshell` (the JShell command-line tool) session that's loaded with your own application source code. It is beginner-friendly!


## Instructions

**NOTE**: This project was developed on macOS for my own personal use. Your mileage may vary.

Follow these instructions to build and run the program via a normal entrypoint and via `jshell`. 

1. Pre-requisite: Java 21
2. Compile the source code
   * ```shell
     ./build.sh 
     ```
3. Run the program
   * ```shell
     ./run-main.sh
     ```
   * This runs the program from a normal `public static void main` method entrypoint. But... this isn't what we are
     really interested in. We want to use JShell! See the next step.
4. Start a `jshell` session which loads the application source code
   * ```shell
     ./run-jshell.sh
     ```
5. Explore!
    * For example, execute the `sayHello` method.
      * `dgroomes.basic.MessageUtil.sayHello("me")`
    * Import the `sayHello` method:
      * `import static dgroomes.basic.MessageUtil.sayHello`
    * Execute the `sayHello` method again but without the fully qualified name (thanks to the import):         
      * `sayHello("you")`
    * When you're done, exit the `jshell` session with `/exit`
    * Altogether, it will look like this:
      ```text
      ./build.sh
      ./run-jshell.sh
      |  Welcome to JShell -- Version 21.0.3
      |  For an introduction type: /help intro
      
      jshell> dgroomes.basic.MessageUtil.sayHello("me")
      Hello,
      me!
      
      jshell> import static dgroomes.basic.MessageUtil.sayHello
      
      jshell> sayHello("you")
      Hello,
      you!
      
      jshell> /exit
      |  Goodbye
      jshell>
      ```
