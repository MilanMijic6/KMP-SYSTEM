package main

data class MainScreenModel(
    val isLoggedIn: Boolean
)

fun setInitState(): MainScreenModel = MainScreenModel(
    isLoggedIn = false
)