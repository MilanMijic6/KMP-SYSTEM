plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    task("testClasses").doLast {
        println("This is a dummy testClasses task")
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "di"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":data"))
                implementation(project(":domain"))
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.multiplatform.settings.noarg)
                implementation(libs.ktor.server.status.pages)
                implementation(libs.ktor.client.logging)
            }
        }

        val androidMain by getting{
            dependencies{
                implementation(libs.ktor.client.okhttp)
            }
        }

        val iosMain by creating{
            dependencies{
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "com.vega.di"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
