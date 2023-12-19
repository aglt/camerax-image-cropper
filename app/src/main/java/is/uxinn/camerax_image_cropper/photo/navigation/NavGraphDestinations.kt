package `is`.uxinn.camerax_image_cropper.photo.navigation


internal sealed class NavDestination(val route: String) {
    data object CameraPermission : NavDestination("permission")
    data object Camera : NavDestination("camera")
    data object CropImage : NavDestination("crop")
}

