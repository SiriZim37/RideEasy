plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinKapt)
    alias(libs.plugins.hiltAndroid)
}
android {
    namespace = "com.siri.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.google.dagger.hilt)
    kapt(libs.google.dagger.hilt.compiler)
    implementation(libs.androidx.paging.runtime)
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.paging.common)
    androidTestImplementation(libs.jetbrains.kotlin.coroutines.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test)
    androidTestImplementation(libs.mockito.core)
    androidTestImplementation(libs.mockito.android)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}