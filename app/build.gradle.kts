plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "is.uxinn.camerax_image_cropper"
    compileSdk = 34

    defaultConfig {
        applicationId = "is.uxinn.camerax_image_cropper"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val lifecycleVersion = "2.6.2"
    val cameraVersion = "1.3.1"
    val hiltAndroid = "2.49"
    val composeBom = "2023.08.00"
    val accompanist = "0.32.0"
    val junit = "4.13.2"
    val espresso = "3.5.1"
    val hiltNavigationCompose = "1.1.0"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:${composeBom}"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")

    implementation("androidx.camera:camera-camera2:${cameraVersion}")
    implementation("androidx.camera:camera-view:${cameraVersion}")
    implementation("androidx.camera:camera-extensions:${cameraVersion}")
    implementation("androidx.camera:camera-lifecycle:${cameraVersion}")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:${lifecycleVersion}")

    implementation("com.google.dagger:hilt-android:${hiltAndroid}")
    implementation("androidx.hilt:hilt-navigation-compose:${hiltNavigationCompose}")
//    annotationProcessor("com.google.dagger:hilt-compiler:${hiltAndroid}")
    kapt("com.google.dagger:hilt-android-compiler:${hiltAndroid}")

    implementation("com.google.accompanist:accompanist-permissions:${accompanist}")

    testImplementation("junit:junit:${junit}")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:${espresso}")
    androidTestImplementation(platform("androidx.compose:compose-bom:${composeBom}"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}