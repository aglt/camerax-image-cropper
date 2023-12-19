@file:OptIn(ExperimentalPermissionsApi::class)

package `is`.uxinn.camerax_image_cropper.photo.navigation

import android.Manifest
import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import `is`.uxinn.camerax_image_cropper.photo.PhotoState
import `is`.uxinn.camerax_image_cropper.photo.camera.CameraScreen
import `is`.uxinn.camerax_image_cropper.photo.cropper.CropPhotoScreen
import `is`.uxinn.camerax_image_cropper.photo.permission.CameraPermissionScreen

@Composable
fun CameraNavGraph(
    photoState: PhotoState,
    navController: NavHostController = rememberNavController(),
    cameraPermissionState: PermissionState =
        rememberPermissionState(Manifest.permission.CAMERA),
    onPhotoCaptured: (Bitmap) -> Unit,
) {
    val startDestination: String = if (cameraPermissionState.status.isGranted) {
        NavDestination.Camera.route
    } else {
        NavDestination.CameraPermission.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavDestination.Camera.route) {
            CameraScreen(
                onPhotoCaptured = onPhotoCaptured,
                photoState = photoState
            )
        }
        composable(NavDestination.CameraPermission.route) {
            CameraPermissionScreen(cameraPermissionState::launchPermissionRequest)
        }
        composable(NavDestination.CropImage.route) {
            CropPhotoScreen()
        }
    }
}