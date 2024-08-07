package dgroomes.with_libraries;

/**
 * Java 16 "Records" let us replace the class defined in PointPojo.java with a more
 * concise source code file. Also, records give us `equals()`, `toString()`, and `hashCode()` for free!
 * <p>
 * Jackson *cannot* serialize/deserialize to this class out-of-the-box. It needs some extra configuration. Specifically,
 * the Jackson ObjectMapper needs to be configured with {@link com.fasterxml.jackson.module.paramnames.ParameterNamesModule}
 */
public record PointRecord(Integer x, Integer y) {
}
