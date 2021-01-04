package dgroomes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SubjectMain {

    public static String POINT_JSON = """
            {
               "x": 1,
               "y": 2
            }
            """;

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("""
                Here is a typical example of writing exploratory code inside of a `public static void main` method. In
                it, we explore the Jackson library and experiment with using the ObjectMapper. Instead of this, try
                JShell! See the README.md for more information.
                """);

        var mapper = new ObjectMapper();

        var point = mapper.readValue(POINT_JSON, PointPojo.class);
        System.out.printf("Found %s using a plain ObjectMapper to deserialize into a plain Pojo class%n", point);
    }
}
