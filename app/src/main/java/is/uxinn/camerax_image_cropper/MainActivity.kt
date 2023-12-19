package `is`.uxinn.camerax_image_cropper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import `is`.uxinn.camerax_image_cropper.photo.PhotoApp
import `is`.uxinn.camerax_image_cropper.photo.PhotoState
import `is`.uxinn.camerax_image_cropper.photo.PhotoViewModel
import `is`.uxinn.camerax_image_cropper.ui.theme.CameraxPhotoCropperTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PhotoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val photoState: PhotoState by viewModel.state.collectAsStateWithLifecycle()
            CameraxPhotoCropperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PhotoApp(
                        photoState = photoState,
                        onPhotoCaptured = {
                            viewModel.storePhotoInGallery(it)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CameraAppPreview() {
    PhotoApp(
        photoState = PhotoState.Empty,
        onPhotoCaptured = {}
    )
}