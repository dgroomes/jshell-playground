package dgroomes.with_gradle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pretty printing a number of bytes into a more readable form.
 * <p>
 * For example, given 1024 (bytes), this utility should identify this amount of bytes as "1 KiB" (kibibyte).
 * <p>
 * NOT FULLY IMPLEMENTED
 * <p>
 * This is a work in progress! Try to load this source code into a JShell session to quickly iterate and experiment with
 * the calculation logic.
 */
public class BytesPrettyPrinter {

    private static final Logger log = LoggerFactory.getLogger(BytesPrettyPrinter.class);

    /**
     * TODO this should be extended to identify MiB, GiB, etc.
     * <p>
     * Calculate a human readable description of the size of of a given number of bytes.
     *
     * @param numberOfBytes the number of bytes to convert into a human readable string.
     * @return a human-readable descriptor of the amount of bytes. For example, "1 KiB"
     */
    public static String humanReadable(long numberOfBytes) {
        if (numberOfBytes == 1024) {
            return "1 KiB";
        } else if (numberOfBytes < 1024) {
            return "less than 1 KiB";
        } else {
            return "greater than 1 KiB";
        }
    }

    /**
     * Pretty print a given number of bytes into human readable form.
     *
     * @param numberOfBytes the number of bytes
     */
    public static void prettyPrint(long numberOfBytes) {
        String humanReadable = humanReadable(numberOfBytes);
        log.info(humanReadable);
    }
}
