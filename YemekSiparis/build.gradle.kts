// build.gradle.kts (proje kökünde)

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library)     apply false
    alias(libs.plugins.kotlin.android)      apply false
    alias(libs.plugins.kotlin.kapt)         apply false  // ← kapt alias’ı eklendi
    alias(libs.plugins.navigation.safeargs) apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
