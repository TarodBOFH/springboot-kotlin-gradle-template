allprojects {
    buildscript {
        apply(from = "${rootProject.projectDir}/buildSrc/versions.gradle.kts") // parent properties
        apply(from = "${rootProject.projectDir}/versions.gradle.kts") // can override "parent" properties
    }
}

plugins {
    id("common.gradle.scripts.versions")
    id("common.gradle.scripts.idea")
    id("common.gradle.scripts.kotlin-jvm")
    id("common.gradle.scripts.kotlin-test")
    id("common.gradle.scripts.spring-kotlin")
    id("common.gradle.scripts.spotless-kotlin")
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "6.8.2"
}
