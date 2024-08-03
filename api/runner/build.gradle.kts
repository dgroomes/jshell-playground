plugins {
    application
}

application {
    mainClass.set("dgroomes.api.runner.RunnerMain")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.slf4j.api)
    runtimeOnly(libs.slf4j.simple)
}
