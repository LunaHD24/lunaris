plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.5"
}

group = "dev.lunaa.lunaris"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    implementation(project(":api"))
}

tasks.compileJava {
    options.release = 21
}

tasks.test {
    useJUnitPlatform()
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.jar {
    enabled = false
}

tasks.shadowJar {
    archiveBaseName.set("Lunaris")
    archiveVersion.set(version.toString())
    archiveClassifier.set("")
    relocate("dev.lunaa.lunaris.api", "dev.lunaa.lunaris.internal.api")
}

tasks {
    javadoc {
        options {
            (this as CoreJavadocOptions).addBooleanOption("Xdoclint:none", true)
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withSourcesJar()
    withJavadocJar()
}