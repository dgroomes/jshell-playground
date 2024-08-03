# api

Explore the JShell API by implementing a custom event loop.

Note: the JShell API is different from the JShell *tool*. The JShell tool is the REPL that is implemented using the
building blocks of the JShell API. The JShell tool is usually invoked via the `jshell` executable but can be invoked
programmatically via an API of its own (confusing, I know! I was spinning on this for a long time). With the JShell API,
we can implement our own tooling. I'm learning about the API in the hopes that I can integrate it into Intellij via an Intellij
plugin as a prototype or hack on the JShell integration that already exists in the Intellij Platform.


## Design

This subproject is implemented in two subprojects of its own:

* `subject/`. This subproject contains our "subject" code, meaning the code we want to experiment with via a JShell
  session. In a normal project, this would be our application and library code but in this project it is just a means to
  an end. 
* `runner/`. This subproject contains the `public static void main` method to instantiate a JShell session and
  handle a custom event loop which continuously reads input and executes it in JShell. This subproject is the
  interesting part of the project. In it, we explore the JShell APIs of the `jdk.jshell` package.


## Instructions

1. Pre-requisite: Java 21
2. Build the projects:
    * Build the `subject/` project with the following command.
    * ```shell
      ./gradlew subject:installDist
      ```
    * Build the `runner/` program with the following command.
    * ```shell
      ./gradlew runner:installDist
      ```
3. Run the runner project:
    * ```shell
      runner/build/install/runner/bin/runner
      ```
4. Explore!
    * The JShell session is loaded with all the source code of the `subject/` project and its library dependencies (in
      this case, the Jackson serialization library).
    * For example, try importing and `new`-ing up an instance of `ObjectMapper`:
      * `import com.fasterxml.jackson.databind.ObjectMapper;`
      * `var mapper = new ObjectMapper();`
    * Then, deserialize the JSON string stored in the `POINT_JSON` variable into an instance of `PointPojo`:
      * `mapper.readValue(dgroomes.api.subject.SubjectMain.POINT_JSON, dgroomes.api.subject.PointPojo.class);`
    * Altogether, it will look like this:
      ```text
      13:21:37 INFO RunnerMain - Exploring the JShell API by implementing a custom event loop!
      13:21:37 INFO RunnerMain - Enter Java code snippets below and they will be passed to a JShell session (remote JVM) and executed:
      import com.fasterxml.jackson.databind.ObjectMapper;
      13:21:42 INFO RunnerMain - Snippet event: SnippetEvent(snippet=Snippet:ImportKey(ObjectMapper,SINGLE_TYPE_IMPORT_SUBKIND)#1-import com.fasterxml.jackson.databind.ObjectMapper;,previousStatus=NONEXISTENT,status=VALID,isSignatureChange=true,causeSnippetnull)
      var mapper = new ObjectMapper();
      13:21:46 INFO RunnerMain - Snippet event: SnippetEvent(snippet=Snippet:VariableKey(mapper)#2-var mapper = new ObjectMapper();,previousStatus=NONEXISTENT,status=VALID,isSignatureChange=true,causeSnippetnullvalue=com.fasterxml.jackson.databind.ObjectMapper@5119fb47)
      mapper.readValue(dgroomes.api.subject.SubjectMain.POINT_JSON, dgroomes.api.subject.PointPojo.class);
      13:21:50 INFO RunnerMain - Snippet event: SnippetEvent(snippet=Snippet:VariableKey($1)#3-mapper.readValue(dgroomes.api.subject.SubjectMain.POINT_JSON, dgroomes.api.subject.PointPojo.class);,previousStatus=NONEXISTENT,status=VALID,isSignatureChange=true,causeSnippetnullvalue=PointPojo{x=1, y=2})
      ```
    * It's not pretty because I have only implemented a naive event loop whereas the REPL implemented by the JShell *tool*
    (i.e. `jshell`) gives a better user experience. But, it works!


## Reference

* [Intellij bug: *JShell: "Use classpath of" doesn't work*](https://youtrack.jetbrains.com/issue/IDEA-176418)
* [JavaDoc for the "jdk.shell: module](https://docs.oracle.com/en/java/javase/15/docs/api/jdk.jshell/jdk/jshell/package-summary.html)
