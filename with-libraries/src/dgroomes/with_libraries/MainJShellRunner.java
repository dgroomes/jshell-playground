package dgroomes.with_libraries;

import jdk.jshell.tool.JavaShellToolBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * An alternative "public static void main" method from the normal main method in Main.java. This main method is a
 * simple "runner" that starts the JShell tool programmatically via its Java APIs in the package "jdk.jshell".
 */
public class MainJShellRunner {

    public static void main(String[] args) throws Exception {
        // Build the class path string for the libraries in "lib/" plus the program's own source files in "out/"
        var classPath = Files.walk(Paths.get("lib"))
                .map(Path::toString)
                .collect(Collectors.joining(":"));
        classPath += ":out";

        JavaShellToolBuilder builder = JavaShellToolBuilder.builder();
        builder.run("--feedback", "normal",
                "--startup", "DEFAULT",
                "--startup", "setup-snippets.jsh",
                "--class-path", classPath);
    }
}
