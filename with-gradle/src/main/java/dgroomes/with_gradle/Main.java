package dgroomes.with_gradle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Hello from the 'main' method.");
        int numberOfBytes = 1025;
        log.info("How much is {} bytes?", numberOfBytes);
        BytesPrettyPrinter.prettyPrint(numberOfBytes);
    }
}
