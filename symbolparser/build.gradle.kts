plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("java-library")
    id("maven-publish")
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}
dependencies {
    implementation(libs.symbol.processing.api)
    api(libs.kotlinpoet.ksp)
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
    from("README.md") {
        into("META-INF")
    }
}
publishing {
    publications {
        register("release", MavenPublication::class) {
            groupId = "com.github.ansolm"
            artifactId = "symbolparser"
            version = "0.0.6"
            from(components["java"])
            artifact(sourcesJar)
        }
    }
}