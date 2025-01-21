plugins {
    id("java")
    id("java-library")
    id("maven-publish")
}

group = "de.lunaa.lunaris"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.compileJava {
    options.release = 21
}

tasks.test {
    useJUnitPlatform()
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

publishing {
    publications {
        create<MavenPublication>("api") {
            from(components["java"])

            groupId = "dev.lunaa.lunaris"
            artifactId = "lunaris-api"
            version = "1.0.0"

            pom {
                name.set("Lunaris")
                description.set("API for paper plugin Lunaris, a custom effect library")
                url.set("https://github.com/LunaHD24/lunaris")

                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    }
                }
                developers {
                    developer {
                        id.set("lunaa")
                        name.set("Lunaa")
                        email.set("contact@lunaa.dev")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/LunaHD24/lunaris.git")
                    developerConnection.set("scm:git:ssh://git@github.com/LunaHD24/lunaris.git")
                    url.set("https://github.com/LunaHD24/lunaris")
                }

                repositories {
                    maven {
                        name = "LunarisRepository"
                        url = uri("https://lunaa.dev/repository/")
                    }
                }
            }
        }
    }
}