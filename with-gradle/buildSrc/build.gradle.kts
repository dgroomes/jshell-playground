plugins {
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        create("dependenciesListerPlugin") {
            id = "dgroomes.dependencies-lister"
            implementationClass = "dgroomes.with_gradle.DependenciesListerPlugin"
        }
    }
}
