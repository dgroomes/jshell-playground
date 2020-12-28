package dgroomes;

/**
 * The class with the main method. Normally, this is the entry point for a project. But in this case, you should avoid
 * running the main method in this class and instead try to load the code using JShell. See the README for more
 * information.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("""
                Here is a typical example of writing exploratory code inside of a `public static void main` method. In
                it, we explore "text blocks" and String formatting. This approach works fine, but it requires a full
                re-build and 're-run to completion' to see the results of a code change. An IDE or build tool like
                Gradle makes this pretty easy *if you have already installed and configured these tools*. Alternatively,
                with no additional tools beyond the JDK, we can get a fast-feedback development cycle with a
                Read-Evaluate-Print-Loop courtesy of JShell, the Java shell. This is perfect for absolute beginners
                where time is of the essence to build up their confidence and interest in the language. See the
                README for more information.
                """);

        MessageUtil.sayHello("Java programmer");
    }
}
