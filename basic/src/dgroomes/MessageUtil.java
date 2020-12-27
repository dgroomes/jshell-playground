package dgroomes;

/**
 * Simple Java code for printing a friendly "hello" message.
 */
public class MessageUtil {

    /**
     * A format string. Learn the basics about Java strings at the official "The Java Tutorials" https://docs.oracle.com/javase/tutorial/java/data/strings.html
     */
    public static String HELLO_MESSAGE_TEMPLATE = """
            Hello,
            %s!
            """;

    /**
     * Print a friendly hello message.
     * @param name the name that the message will address
     */
    public static void sayHello(String name) {
        System.out.printf(HELLO_MESSAGE_TEMPLATE, name);
    }
}
