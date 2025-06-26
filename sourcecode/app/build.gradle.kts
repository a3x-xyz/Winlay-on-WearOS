plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.winlayonwearos.a3x"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.winlayonwearos.a3x"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"

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
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("io.coil-kt:coil:2.4.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.wear:wear:1.2.0")
    implementation(libs.play.services.wearable)
}