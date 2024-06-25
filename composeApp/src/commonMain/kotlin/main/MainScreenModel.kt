package main

data class MainScreenModel(
    val isLoggedIn: Boolean,
    val isCreator: Boolean
)

fun setInitState(): MainScreenModel = MainScreenModel(
    isLoggedIn = false,
    isCreator = false
)