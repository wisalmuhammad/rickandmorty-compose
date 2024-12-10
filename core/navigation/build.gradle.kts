plugins {
    id("wisal.android.rickandmorty.library")
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.wisal.android.rickandmorty.core.navigation"
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.compose.navigation)

}