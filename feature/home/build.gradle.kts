plugins {
    id("wisal.android.rickandmorty.feature")
    id("wisal.android.rickandmorty.hilt")
}

android {
    namespace = "com.wisal.android.rickandmorty.feature.home"
}

dependencies {

    implementation(projects.core.designsystem)
    implementation(projects.core.database)

    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime)
}