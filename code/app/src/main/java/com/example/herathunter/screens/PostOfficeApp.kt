package com.example.herathunter.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import MainScreen
@Composable
fun PostOfficeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color= Color.White
    ){
        Crossfade(targetState =PostOfficeAppRouter.currentScreen.value ) { currentState->
            when (currentState) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.LoginScreen -> {
                    LoginScreen()
                }
                is Screen.MainScreen->{
                    MainScreen()
                }

           }
        }
    }
}