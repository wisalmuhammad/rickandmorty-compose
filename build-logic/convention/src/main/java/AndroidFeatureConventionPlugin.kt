import com.android.build.gradle.LibraryExtension
import com.wisal.android.rickandmorty.convention.configureAndroidCompose
import com.wisal.android.rickandmorty.convention.configureKotlinAndroid
import com.wisal.android.rickandmorty.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {

                add("implementation",project(":core:model"))
                add("implementation",project(":core:data"))
                add("implementation", project(":core:navigation"))
                add("implementation", project(":core:network"))
                add("implementation", project(":core:designsystem"))

                add("implementation", libs.findLibrary("androidx-compose-navigation").get())
                add("implementation", libs.findLibrary("androidx-hilt-navigation-compose").get())
                add("implementation",libs.findLibrary("androidx-material3").get())
                add("implementation",libs.findLibrary("github-bumptech-glid").get())
            //add("implementation", project(":core:data"))
                //add("compileOnly", project(":core:preview"))
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                defaultConfig.targetSdk = 35
            }

            extensions.getByType<KotlinAndroidProjectExtension>().apply {
                configureKotlinAndroid(this)
            }
        }
    }
}