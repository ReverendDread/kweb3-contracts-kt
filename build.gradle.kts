plugins {
    kotlin("jvm") version "1.8.20"
    id("maven-publish")
}

group = "dev.klepto.kweb3"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.klepto:kweb3:d52c74ba03")

    testImplementation(kotlin("test"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.klepto.kweb3"
            artifactId = "kweb3-contracts-kt"
            version = "1.0.0"

            from(components["java"])
        }
    }
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}