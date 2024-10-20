plugins {
    kotlin("jvm")
    `java-library`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

}

tasks.test {
    useJUnitPlatform()
}