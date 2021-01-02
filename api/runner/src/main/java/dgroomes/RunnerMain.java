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
    private final String classpath;

    public static void main(String[] args) {
        log.info("Exploring the JShell API!");
        var classPath = System.getProperty("java.class.path");
        log.info("The 'runner' program (client JVM) is running using java.class.path={}\n\n", classPath);

        var classPathSubject = "/Users/davidgroomes/repos/personal/jshell-playground/api/subject/build/install/subject/lib/*"; // not implemented dynamically yet.
        var main = new RunnerMain(classPathSubject);

        main.runCustomLoop();
    }

    /**
     * @param classpath the classpath that will be used for the remove JVM in the JShell session
     */
    public RunnerMain(String classpath) {
        this.classpath = classpath;
    }

    /**
     * Continuously read Java code snippets from the console and execute them in JShell. This is a so-called "custom loop"
     * because it is an alternative implementation of the JShell *tool*'s own Read-Evaluate-Print-Loop (REPL).
     *
     * Why make a custom loop? Because I want to eventually integrate a custom loop into an Intellij plugin which has
     * different input/output needs than the JShell tool's REPL.
     */
    private void runCustomLoop() {
        console = System.console();
        var builder = JShell.builder()
                .remoteVMOptions("--class-path", classpath)
                .compilerOptions("--class-path", classpath);

        try (JShell jShell = builder.build()) {
            this.jShell = jShell;

            var classpath = jShell.eval("""
                    System.getProperty("java.class.path");""").get(0).value();
            log.info("The JShell session (remote JVM) is executing with the class path: {}\n\n", classpath);

            log.info("Enter Java code snippets below and they will be passed to a JShell session (remote JVM) and executed:");
            while (true) {
                readAndEvaluate();
            }
        }
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
