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
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("commons-io:commons-io:2.5")

    // Test
    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

tasks.test {
    useJUnitPlatform()
}


application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}