# api

This sub-project explores the JShell API by implementing a custom event loop.

Note: the JShell API is different than the JShell *tool*. The JShell tool is the REPL that is implemented using the
building blocks of the JShell API. The JShell tool is usually invoked via the `jshell` executable but can be invoked
programmatically via an API of its own (confusing, I know! I was spinning on this for a long time). With the JShell API,
we can implement our own tooling. I'm learning about the API in the hopes that I can integrate it into Intellij via an Intellij
plugin as a prototype or hack on the JShell integration that already exists in the Intellij Platform.

## Design

This sub-project is implemented in two sub-projects of its own:

* `subject/`. This sub-project contains our "subject" code, meaning the code we want to experiment with via a JShell
  session. In a normal project, this would be our application and library code but in this project it is just a means to
  an end. 
* `runner/`. This sub-project contains the `public static void main` method to instantiate a JShell session and
  handle a custom event loop which continuously reads input and executes it in JShell. This sub-project is the
  interesting part of the project. In it, we explore the JShell APIs of the `jdk.jshell` package.

## Instructions

1. Build the projects:
    * Build the `subject/` project with `./gradlew subject:installDist`
    * Build the `runner/` program with `./gradlew runner:installDist`
1. Run the runner project:
    * `runner/build/install/runner/bin/runner`
1. Explore!
    * The JShell session is loaded with all of the source code of the `subject/` project and its library dependencies (in
      this case, the Jackson serialization library).
    * For example, try importing and `new`-ing up an instance of `ObjectMapper`:
      * `import com.fasterxml.jackson.databind.ObjectMapper;`
      * `var mapper = new ObjectMapper(); `
    * Then, deserialize the JSON string stored in the `POINT_JSON` variable into an instance of `PointPojo`:
      * `mapper.readValue(dgroomes.SubjectMain.POINT_JSON, dgroomes.PointPojo.class);`
    * Altogether, it will look like this:
      ```
      runner/build/install/runner/bin/runner
      00:03:06 INFO RunnerMain - Exploring the JShell API by implementing a custom event loop!
      00:03:06 INFO RunnerMain - Enter Java code snippets below and they will be passed to a JShell session (remote JVM) and executed:
      import com.fasterxml.jackson.databind.ObjectMapper;
      00:03:14 INFO RunnerMain - Snippet event: SnippetEvent(snippet=Snippet:ImportKey(ObjectMapper,SINGLE_TYPE_IMPORT_SUBKIND)#1-import com.fasterxml.jackson.databind.ObjectMapper;,previousStatus=NONEXISTENT,status=VALID,isSignatureChange=true,causeSnippetnull)
      var mapper = new ObjectMapper();
      00:03:20 INFO RunnerMain - Snippet event: SnippetEvent(snippet=Snippet:VariableKey(mapper)#2-var mapper = new ObjectMapper(); ,previousStatus=NONEXISTENT,status=VALID,isSignatureChange=true,causeSnippetnullvalue=com.fasterxml.jackson.databind.ObjectMapper@27c20538)
      mapper.readValue(dgroomes.SubjectMain.POINT_JSON, dgroomes.PointPojo.class);
      00:03:24 INFO RunnerMain - Snippet event: SnippetEvent(snippet=Snippet:VariableKey($1)#3-mapper.readValue(dgroomes.SubjectMain.POINT_JSON, dgroomes.PointPojo.class);,previousStatus=NONEXISTENT,status=VALID,isSignatureChange=true,causeSnippetnullvalue=PointPojo{x=1, y=2})
      ```
    * It's not pretty because I have only implemented a naive event loop whereas the REPL implemented by the JShell *tool*
    (i.e. `jshell`) gives a better user experience. But, it works!

Tip: for a conveniently fast "develop and run" experience try aliasing the build and run commands together:
* `alias doit="./gradlew subject:installDist runner:installDist && runner/build/install/runner/bin/runner"`
* `doit`
* Make a code change.
* `doit`
* Etc.

### Reference materials

* [Intellij bug: *JShell: "Use classpath of" doesn't work*](https://youtrack.jetbrains.com/issue/IDEA-176418)
* [JavaDoc for the "jdk.shell: module](https://docs.oracle.com/en/java/javase/15/docs/api/jdk.jshell/jdk/jshell/package-summary.html)
