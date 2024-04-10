package com.example.herathunter.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import MainScreen
import Theme
import android.util.Log

@Composable
fun PostOfficeApp(currentTheme: Theme, onThemeChange: (Theme) -> Unit)
 {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color= Color.White
    ){
        Log.e("my","start post")
        Crossfade(targetState =PostOfficeAppRouter.currentScreen.value ) { currentState->
            when (currentState) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.LoginScreen -> {
                    LoginScreen()
                }
                is Screen.MainScreen->{
                    MainScreen(currentTheme) { newTheme ->
                        onThemeChange(newTheme)
                    }
                }

                }
        }
    }
}