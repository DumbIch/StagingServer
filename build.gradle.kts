val kotlinVersion: String by project
val ktorVersion: String by project
val logbackVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.serialization") version "1.6.0"
    id("io.ktor.plugin") version "2.2.4"
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
    implementation("io.ktor:ktor-server-resources:$ktorVersion")
    implementation("io.ktor:ktor-server-html-builder:$ktorVersion")
    implementation("io.ktor:ktor-server-default-headers:$ktorVersion")
    implementation("io.ktor:ktor-server-freemarker:$ktorVersion")
    implementation("io.ktor:ktor-server-call-logging:$ktorVersion")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")

    // LogBack
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("commons-io:commons-io:2.11.0")
    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
}

tasks.test {
    useJUnitPlatform()
}


application {
    mainClass.set("com.dumdumbich.stsrv.server.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

ktor {
    fatJar {
        archiveFileName.set("stsrv.jar")
    }
}
