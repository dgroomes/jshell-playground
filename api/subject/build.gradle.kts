plugins {
    java
    application
}

val jacksonVersion = "2.12.0" // releases: https://github.com/FasterXML/jackson/wiki/Jackson-Releases

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
}

application {
    mainClass.set("dgroomes.SubjectMain")
}
