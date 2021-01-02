package dgroomes;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Console;
import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private JShell jShell;
    private Console console;

    public static void main(String[] args) {
        log.info("Exploring the JShell API. Enter Java code snippets below and they will be passed to a JShell session and executed!");

        var main = new Main();
        main.run();
    }

    /**
     * Continuously read Java code snippets from the console and execute them in JShell.
     */
    private void run() {
        console = System.console();
        try (JShell jShell = JShell.create()) {
            this.jShell = jShell;
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
