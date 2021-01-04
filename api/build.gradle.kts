subprojects {
    apply(plugin = "java")
    apply(plugin = "application")

    repositories {
        mavenLocal()
        jcenter()
    }

    val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html

    dependencies {
        "implementation"("org.slf4j:slf4j-api:$slf4jVersion")
        "implementation"("org.slf4j:slf4j-simple:$slf4jVersion")
    }
}
