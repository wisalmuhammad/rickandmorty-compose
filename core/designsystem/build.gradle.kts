plugins {
    id("wisal.android.rickandmorty.library")
    id("wisal.android.rickandmorty.library.compose")
}

android {
    namespace = "com.wisal.android.rickandmorty.core.designsystem"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material3)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
}