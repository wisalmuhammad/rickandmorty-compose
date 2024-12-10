plugins {
    id("wisal.android.rickandmorty.feature")
    id("wisal.android.rickandmorty.hilt")
}

android {
    namespace = "com.wisal.android.rickandmorty.feature.details"
}

dependencies {

    implementation(projects.core.designsystem)
    implementation(projects.core.database)

}