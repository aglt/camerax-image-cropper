@file:OptIn(ExperimentalPermissionsApi::class)

package `is`.uxinn.camerax_image_cropper.photo

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import `is`.uxinn.camerax_image_cropper.photo.navigation.CameraNavGraph
import `is`.uxinn.camerax_image_cropper.ui.theme.CameraxPhotoCropperTheme

@Composable
fun PhotoApp(
    photoState: PhotoState,
    onPhotoCaptured: (Bitmap) -> Unit
) {
    CameraxPhotoCropperTheme {
        CameraNavGraph(photoState = photoState, onPhotoCaptured = onPhotoCaptured)
    }
}