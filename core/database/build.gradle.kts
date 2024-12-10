plugins {
    id("wisal.android.rickandmorty.library")
    id("wisal.android.rickandmorty.hilt")
}

android {
    namespace = "com.wisal.android.rickandmorty.core.database"
}

dependencies {

    implementation(projects.core.model)

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)

    implementation(libs.androidx.room.paging)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime)

    ksp(libs.androidx.room.compiler)


}