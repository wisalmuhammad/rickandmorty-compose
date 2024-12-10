plugins {
    id("wisal.android.rickandmorty.library")
    id("wisal.android.rickandmorty.library.compose")
    id("wisal.android.rickandmorty.hilt")
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.wisal.android.rickandmorty.core.network"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(projects.core.model)

    implementation(libs.bundles.retrofitBundle)
    implementation(libs.kotlinx.serialization.json)
}