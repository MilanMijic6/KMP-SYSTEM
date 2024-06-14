package main.profile

import AlertMessageDialog
import ImageSourceOptionDialog
import PermissionCallback
import PermissionStatus
import PermissionType
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.vega.domain.model.profile.User
import convertBitmapToString
import createPermissionsManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.compose.koinInject
import rememberCameraManager
import rememberGalleryManager
import ui.ColorLightGray
import ui.ColorPurple
import util.CenteredDialog
import util.HeaderText
import util.LinkText
import util.Loader
import util.PurpleButton
import util.RoundedImage
import util.RoundedTextInput

class ProfileScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: ProfileViewModel = koinInject()
        val handleEvent: (ProfileUserContract.Event) -> Unit = { viewModel.handleEvents(it) }
        var errorTitle: String? = ""
        val shouldShowDialog = remember { mutableStateOf(false) }

        if (shouldShowDialog.value) {
            CenteredDialog(
                title = errorTitle ?: "Something went wrong",
                buttonText = "Dismiss",
                descriptionText = "Dismiss",
                onNegativeClick = {
                    shouldShowDialog.value = false
                },
                onPositiveClick = {
                    shouldShowDialog.value = false
                }
            )
        }

        when (val state = viewModel.viewState.value) {
            is ProfileUserContract.State.Error -> {
                errorTitle = state.profilerUserModel.errorMsg
                shouldShowDialog.value = true
            }

            is ProfileUserContract.State.Init -> {
                UserInfoContent(
                    scrollState = rememberScrollState(),
                    user = state.profilerUserModel.user,
                    state = state,
                    handleEvent = handleEvent
                )
            }

            is ProfileUserContract.State.Loading -> {
                Loader()
            }

            is ProfileUserContract.State.UpdateSuccess -> {
                LaunchedEffect(Unit) {
                    viewModel.handleEvents(ProfileUserContract.Event.ShowUserInfo)
                }
                UserInfoContent(
                    scrollState = rememberScrollState(),
                    user = state.profilerUserModel.user,
                    state = state,
                    handleEvent = handleEvent
                )
            }
        }
        LaunchedEffect(Unit) {
            viewModel.handleEvents(ProfileUserContract.Event.ShowUserInfo)
        }
    }

    @Composable
    private fun UserInfoContent(
        scrollState: ScrollState,
        user: User,
        state: ProfileUserContract.State,
        handleEvent: (ProfileUserContract.Event) -> Unit
    ) {
        val coroutineScope = rememberCoroutineScope()
        var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
        var imageSourceOptionDialog by remember { mutableStateOf(value = false) }
        var launchCamera by remember { mutableStateOf(value = false) }
        var launchGallery by remember { mutableStateOf(value = false) }
        var launchSetting by remember { mutableStateOf(value = false) }
        var permissionRationalDialog by remember { mutableStateOf(value = false) }
        val permissionsManager = createPermissionsManager(object : PermissionCallback {
            override fun onPermissionStatus(
                permissionType: PermissionType,
                status: PermissionStatus
            ) {
                when (status) {
                    PermissionStatus.GRANTED -> {
                        when (permissionType) {
                            PermissionType.CAMERA -> launchCamera = true
                            PermissionType.GALLERY -> launchGallery = true
                        }
                    }

                    else -> {
                        permissionRationalDialog = true
                    }
                }
            }
        })

        val cameraManager = rememberCameraManager {
            coroutineScope.launch {
                val bitmap = withContext(Dispatchers.Default) {
                    it?.toImageBitmap()
                }
                imageBitmap = bitmap
                handleEvent(ProfileUserContract.Event.UpdateProfilePicture(convertBitmapToString(imageBitmap)))
            }
        }

        val galleryManager = rememberGalleryManager {
            coroutineScope.launch {
                val bitmap = withContext(Dispatchers.Default) {
                    it?.toImageBitmap()
                }
                imageBitmap = bitmap
                handleEvent(ProfileUserContract.Event.UpdateProfilePicture(convertBitmapToString(imageBitmap)))
            }
        }

        if (imageSourceOptionDialog) {
            ImageSourceOptionDialog(onDismissRequest = {
                imageSourceOptionDialog = false
            }, onGalleryRequest = {
                imageSourceOptionDialog = false
                launchGallery = true
            }, onCameraRequest = {
                imageSourceOptionDialog = false
                launchCamera = true
            })
        }

        if (launchGallery) {
            if (permissionsManager.isPermissionGranted(PermissionType.GALLERY)) {
                galleryManager.launch()
            } else {
                permissionsManager.askPermission(PermissionType.GALLERY)
            }
            launchGallery = false
        }

        if (launchCamera) {
            if (permissionsManager.isPermissionGranted(PermissionType.CAMERA)) {
                cameraManager.launch()
            } else {
                permissionsManager.askPermission(PermissionType.CAMERA)
            }
            launchCamera = false
        }

        if (launchSetting) {
            permissionsManager.launchSettings()
            launchSetting = false
        }

        if (permissionRationalDialog) {
            AlertMessageDialog(title = "Permission Required",
                message = "To set your profile picture, please grant this permission. You can manage permissions in your device settings.",
                positiveButtonText = "Settings",
                negativeButtonText = "Cancel",
                onPositiveClick = {
                    permissionRationalDialog = false
                    launchSetting = true

                },
                onNegativeClick = {
                    permissionRationalDialog = false
                })
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(
                    color = ColorLightGray
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = ColorLightGray
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .background(
                                color = ColorPurple
                            )
                    )
                    RoundedImage(
                        modifier = Modifier,
                        icon = user.profilePicture,
                        bitmap = imageBitmap
                    ) {
                        imageSourceOptionDialog = true
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HeaderText(
                        text = user.name,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(
                                top = 20.dp
                            )
                    )
                    LinkText(
                        text = "8m ago",
                        textAlign = TextAlign.End,
                        color = ColorPurple,
                        textSize = 14.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 20.dp,
                                end = 16.dp
                            )
                    )
                    RoundedTextInput(
                        text = user.name
                    ) {
                        handleEvent(ProfileUserContract.Event.UpdateNameInput(it))
                    }
                    LinkText(
                        text = "30m ago",
                        textAlign = TextAlign.End,
                        color = ColorPurple,
                        textSize = 14.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 30.dp,
                                end = 16.dp
                            )
                    )
                    RoundedTextInput(
                        text = user.email,
                        modifier = Modifier
                            .padding(
                                bottom = 30.dp
                            )
                    ) {
                        handleEvent(ProfileUserContract.Event.UpdateEmailInput(it))
                    }

                    PurpleButton(
                        text = "Submit",
                        enabled = state.profilerUserModel.isEditedName ||
                                state.profilerUserModel.isEditedEmail ||
                                state.profilerUserModel.isEditedPicture,
                        modifier = Modifier
                            .padding(
                                vertical = 16.dp,
                                horizontal = 16.dp
                            )
                    ) {
                        handleEvent(
                            ProfileUserContract.Event.SubmitButtonClick
                        )
                    }
                }
            }
        }
    }
}