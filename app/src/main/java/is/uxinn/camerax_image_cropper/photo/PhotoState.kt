package `is`.uxinn.camerax_image_cropper.photo

import android.graphics.Bitmap

data class PhotoState(
    val capturedImage: Bitmap? = null,
) {
    companion object {
        val Empty = PhotoState()
    }
}
