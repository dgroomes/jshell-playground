plugins {
    java
    application
}

/*
  Warning: This Gradle build file only exists to ease the developer experience when opening this project in an IDE. See the
  extensive note in the file `settings.gradle.kts` for more information. This Gradle file is not meant to be used as an
  example.

  This build file will define the subprojects `basic/` and `with-libraries/` as Gradle projects so that Intellij will
  automatically recognize the source code, recognize the library dependencies and provide a working "click
  the green play button to execute the program" experience. But, importantly, these subprojects still work as standalone
  projects without Gradle. Read their individual README files for instructions on running them (no Gradle involved).

  A good test for validating that this Gradle configuration works is to build from source using Gradle. Try it with:
    * `./gradlew basic:build`
    * `./gradlew with-libraries:build`

  A better test is to open this project in Intellij, wait for Intellij to make sense of the project, and then click the
  green play buttons in the editor gutter on the "public static void main" methods. The program should run.
 */

val basic = project("basic")
val withLibraries = project(":with-libraries")

configure(listOf(basic, withLibraries)) {
    apply(plugin = "java")
    apply(plugin = "application")

    repositories {
        mavenCentral()
    }

    sourceSets {
        main {
            java {
                setSrcDirs(listOf("src"))
            }
        }
    }
}

configure(listOf(withLibraries)) {

    dependencies {
        implementation(fileTree("lib"))
    }
}

