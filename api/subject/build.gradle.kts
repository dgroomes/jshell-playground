plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.slf4j.api)
    runtimeOnly(libs.slf4j.simple)
    implementation(libs.jackson.databind)
}

application {
    mainClass.set("dgroomes.api.subject.SubjectMain")
}
