# with-libraries

This subproject is similar to `basic/` buts adds a few external Java libraries (including [Jackson](https://github.com/FasterXML/jackson)).


## Instructions

Follow these instructions to build the project and run `jshell`.

1. Use Java 17
2. Compile the source code
   * ```shell
     ./build.sh
     ```
3. Run the program
   * ```shell
     ./run-main.sh
     ```
   * This runs the program with a normal `public static void main` method entrypoint. But... this isn't what we are
     really interested in. We want to use JShell! See the next steps where we load the program source code into a
   * `jshell` session.
4. Start a `jshell` session which loads the program and library source code
   * ```shell
     ./run-jshell.sh
     ```
5. Explore!
   * The `jshell` session will be preloaded with some convenience imports, so you can get busy experimenting with `ObjectMapper`
     and the custom classes `PointPojo` and `PointRecord`.
   * For example, try `new`-ing up an instance of `ObjectMapper`:
     * `var mapper = new ObjectMapper()`
   * Then, deserialize the JSON string stored in the `POINT_JSON` variable into an instance of `PointPojo`:
     * `mapper.readValue(POINT_JSON, PointPojo.class)`
     * Pay close attention to the output in your `jshell` session!
   * Next, try deserializing the same JSON string into an instance of `PointRecord` which makes use of the Java "Records"
     feature (spoiler alert! it will throw an exception):
     * `mapper.readValue(POINT_JSON, PointRecord.class)`
   * That yield a serialization error. I think we need to use a specially-configured version of the `ObjectMapper` to be able to
     deserialize into a class that uses the Java "Records" feature. Try this:
     * `var mapperWithParamNames = new ObjectMapper().registerModule(new ParameterNamesModule())`
   * Try to deserialize the JSON to `PointRecord` again but this time use the specialized `ObjectMapper`:
     * `mapperWithParamNames.readValue(POINT_JSON, PointRecord.class)`
     * It worked! We learned something about the Jackson library and did it in a REPL!
   * When you're done, exit the `jshell` session with `/exit`
   * Altogether, it will look like this:
     ```text
     ./build.sh
     ./run-jshell.sh
     |  Welcome to JShell -- Version 17.0.7
     |  For an introduction type: /help intro

     
     jshell> var mapper = new ObjectMapper()
     mapper ==> com.fasterxml.jackson.databind.ObjectMapper@20322d26
     
     jshell> mapper.readValue(POINT_JSON, PointPojo.class)
     $2 ==> PointPojo{x=1, y=2}
     
     jshell> mapper.readValue(POINT_JSON, PointRecord.class)
     |  Exception com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `dgroomes.PointRecord` (no Creators, like default construct, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
     at [Source: (String)"{
     "x": 1,
     "y": 2
     }
     "; line: 2, column: 4]
     |        at InvalidDefinitionException.from (InvalidDefinitionException.java:67)
     |        at DeserializationContext.reportBadDefinition (DeserializationContext.java:1592)
     |        at DeserializationContext.handleMissingInstantiator (DeserializationContext.java:1058)
     |        at BeanDeserializerBase.deserializeFromObjectUsingNonDefault (BeanDeserializerBase.java:1315)
     |        at BeanDeserializer.deserializeFromObject (BeanDeserializer.java:326)
     |        at BeanDeserializer.deserialize (BeanDeserializer.java:159)
     |        at ObjectMapper._readMapAndClose (ObjectMapper.java:4218)
     |        at ObjectMapper.readValue (ObjectMapper.java:3214)
     |        at ObjectMapper.readValue (ObjectMapper.java:3182)
     |        at (#3:1)
     
     jshell> var mapperWithParamNames = new ObjectMapper().registerModule(new ParameterNamesModule())
     ...>
     mapperWithParamNames ==> com.fasterxml.jackson.databind.ObjectMapper@797badd3
     
     jshell> mapperWithParamNames.readValue(POINT_JSON, PointRecord.class)
     $5 ==> PointRecord[x=1, y=2]
     
     jshell> /exit
     |  Goodbye
     ```


## Programmatically starting the JShell tool

The JShell tool can be started programmatically from Java code instead of from the `jshell` executable. To do this, follow
the instructions listed above but instead of `./run-jshell.sh` use `./run-jshell-programmatically.sh`.
