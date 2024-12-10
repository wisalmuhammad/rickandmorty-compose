plugins {
    id("wisal.android.rickandmorty.library")
    id("wisal.android.rickandmorty.library.compose")
    id("wisal.android.rickandmorty.hilt")
}

android {
    namespace = "com.wisal.android.rickandmorty.core.data"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.network)
    implementation(projects.core.database)

    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    implementation(libs.bundles.retrofitBundle)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)

}