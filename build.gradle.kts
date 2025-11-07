plugins {
    java
    id("com.diffplug.spotless") version "8.0.0"
    id("com.github.ben-manes.versions") version "0.53.0"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

dependencies {
    // Align JUnit artifacts
    testImplementation(platform("org.junit:junit-bom:6.0.1"))

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    // Ensure JUnit Platform launcher is available on the test runtime classpath
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.2")

    testImplementation("org.assertj:assertj-core:3.26.3")
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlinGradle {
        ktlint()
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
