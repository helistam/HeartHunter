package com.example.herathunter.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    object SignUpScreen : Screen()
    object LoginScreen : Screen()
    object MainScreen: Screen()
}
object PostOfficeAppRouter {
    var currentScreen: MutableState<Screen> =mutableStateOf(Screen.SignUpScreen)
    fun navigateTo(destination:Screen){
        currentScreen.value=destination
    }
}