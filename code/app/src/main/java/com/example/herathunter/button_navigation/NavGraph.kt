import androidx.compose.runtime.Composable
import androidx.compose.ui.window.isPopupLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
@Composable
fun NavGraph(navHostController: NavHostController, currentTheme: Theme, onThemeChange: (Theme) -> Unit)
{NavHost(navController = navHostController, startDestination = "screen_1"){

        composable("screen_1"){
            Screen1()
        }
        composable("screen_2"){
            Screen2()
        }
        composable("screen_3"){
            Screen3(){
                navHostController.navigate("screen_5")//срабатывает на onClicked
                {
                    popUpTo("screen_3")
                }
            }
        }
        composable("screen_4"){
            //Screen4()
            Screen4(currentTheme) { newTheme ->
                onThemeChange(newTheme)
            }
        }

        composable("screen_5"){
            Screen5(){
                navHostController.navigate("screen_3")//срабатывает на onClicked
                {
                    popUpTo("screen_3")
                }
            }
        }
    }
}