val kotlinVersion: String by project
val ktorVersion: String by project
val logbackVersion: String by project

plugins {
    kotlin("jvm") version "1.6.0"
    application
}

group = "com.dumdumbich"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Ktor
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")

    // LogBack
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // Kotlin
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")

    // Test
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}


application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}