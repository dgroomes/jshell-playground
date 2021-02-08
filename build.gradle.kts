plugins {
    java
    application
}

/*
  Warning: This Gradle build file only exists to ease the developer experience when opening this project in an IDE. See the
  extensive note in the file `settings.gradle.kts` for more information. This Gradle file is not meant to be used as an
  example.

  This build file will define the sub-projects `basic/` and 'with-libraries/` as Gradle projects so that Intellij will
  automatically recognize the source code, recognize the library dependencies and provide a working "click
  the green play button to execute the program" experience. But, importantly, these sub-projects still work as standalone
  projects without Gradle. Read their individual README files for instructions on running them (no Gradle involved).

  A good test for validating that this Gradle configuration works is to actually execute the main programs. Try it with:
    * `./gradlew basic:run`
    * `./gradlew with-libraries:run`

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

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(15))
        }
    }

    sourceSets {
        main {
            java {
                setSrcDirs(listOf("src"))
            }
        }
    }

    application {
        mainClass.set("dgroomes.Main")
    }
}

/**
 * The "with-libraries" project uses preview features so we have to tell Gradle to enable preview features.
 */
configure(listOf(withLibraries)) {

    tasks {
        withType<JavaCompile> {
            options.compilerArgs.addAll(listOf("--enable-preview", "--enable-preview", "--release", "15"))
        }
        withType<Test> {
            jvmArgs("--enable-preview")
        }
        withType<JavaExec> {
            jvmArgs("--enable-preview")
        }
    }

    dependencies {
        implementation(fileTree("lib"))
    }
}

