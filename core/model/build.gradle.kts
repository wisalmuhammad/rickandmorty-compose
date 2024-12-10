plugins {
//    alias(libs.plugins.android.library)
//    alias(libs.plugins.kotlin.android)

    id("wisal.android.rickandmorty.library")
    id("wisal.android.rickandmorty.library.compose")
    id("wisal.android.rickandmorty.hilt")
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.wisal.android.rickandmorty.core.model"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}