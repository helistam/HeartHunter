import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


enum class Theme {
    Light, Dark
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(currentTheme: Theme, onThemeChange: (Theme) -> Unit) {
    //var currentTheme by remember { mutableStateOf(Theme.Light) }
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
        }
        NavGraph(navHostController = navController, currentTheme = currentTheme) { newTheme ->
            onThemeChange(newTheme)
        }
    }
}
