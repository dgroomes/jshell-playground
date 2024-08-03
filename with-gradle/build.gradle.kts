plugins {
    application
    id("dgroomes.dependencies-lister")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.slf4j.api)
    runtimeOnly(libs.slf4j.simple)
}

application {
    mainClass.set("dgroomes.with_gradle.Main")
}
