package dgroomes;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import jdk.jshell.tool.JavaShellToolBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Console;
import java.util.List;

public class RunnerMain {

    private static final Logger log = LoggerFactory.getLogger(RunnerMain.class);

    private JShell jShell;
    private Console console;

    public static void main(String[] args) throws Exception {
        int numArgs = args.length;
        if (numArgs != 1) {
            throw new IllegalStateException("Exactly 1 argument was expected but found %d".formatted(numArgs));
        }

        log.info("Exploring the JShell API!");
        var classPath = System.getProperty("java.class.path");
        log.info("The 'runner' program (client JVM) is running using java.class.path={}\n\n", classPath);

        var main = new RunnerMain();
        var impl = args[0];
        switch (impl) {
            case "tool" -> main.runJShellTool();
            case "custom" -> {
                var classPathSubject = "/Users/davidgroomes/repos/personal/jshell-playground/api/subject/build/install/subject/lib/*"; // not implemented dynamically yet.
                main.runCustomLoop(classPathSubject);
            }
            default -> throw new IllegalArgumentException("Unknown option: '%s'".formatted(impl));
        }
    }

    /**
     * Continuously read Java code snippets from the console and execute them in JShell. This is a so-called "custom loop"
     * because it is an alternative implementation of the JShell *tool*'s own Read-Evaluate-Print-Loop (REPL).
     * <p>
     * Why make a custom loop? Because I want to eventually integrate a custom loop into an Intellij plugin which has
     * different input/output needs than the JShell tool's REPL.
     *
     * @param classpath the classpath that will be used for the remote JVM in the JShell session
     */
    private void runCustomLoop(String classpath) {
        console = System.console();
        if (console == null) {
            throw new IllegalStateException("No access to the console. This program must be run from the command line." +
                    "Are you running from an IDE?");
        }
        var builder = JShell.builder()
                .remoteVMOptions("--class-path", classpath)
                .compilerOptions("--class-path", classpath);

        try (JShell jShell = builder.build()) {
            this.jShell = jShell;

            var foundClasspath = jShell.eval("""
                    System.getProperty("java.class.path");""").get(0).value();
            log.info("The JShell session (remote JVM) is executing with the class path: {}\n\n", foundClasspath);

            log.info("Enter Java code snippets below and they will be passed to a JShell session (remote JVM) and executed:");
            while (true) {
                readAndEvaluate();
            }
        }
    }

    /**
     * Run the JShell "tool" programmatically. This starts the JShell tool's own REPL.
     * <p>
     * In theory, this method should invoke the JShell tool in the same way that the command line executable "jshell"
     * does it. THIS DOES NOT WORK because I can't figure out what's going on with the classpath. The JShell session is
     * always giving me a "not found" kind of error when I try to import a Jackson class or the MainSubject class...
     */
    private void runJShellTool() throws Exception {
        JavaShellToolBuilder builder = JavaShellToolBuilder.builder();
        builder.run("--feedback",
                "normal",
                "--startup",
                "DEFAULT",
                "--class-path",
                "/Users/davidgroomes/repos/personal/jshell-playground/api/subject/build/install/subject/lib/");
    }

    /**
     * Read a snippet from the console and evaluate it via JShell.
     * <p>
     * Logs the outcome of the snippet after it was evaluated.
     */
    private void readAndEvaluate() {
        String input = console.readLine();
        if (input == null || input.isBlank()) {
            log.warn("Nothing was entered. Try again:");
            return;
        }

        log.trace("Evaluating: {}", input);
        List<SnippetEvent> events = jShell.eval(input);
        for (SnippetEvent event : events) {
            if (event.status() == Snippet.Status.REJECTED) {
                log.error("Snippet event: {}", event);
            } else {
                log.info("Snippet event: {}", event);
            }
        }
    }
}
