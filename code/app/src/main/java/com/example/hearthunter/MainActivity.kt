package com.example.hearthunter

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hearthunter.services.AppService

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           /* LazyColumn (){//элементы во время скрола остаются на том же месте
               items(count=10){
                   ListItem("Name","Surname")
               }
            }*/
//            var aps = AppService()
//            aps.postUser()
            MainScreen()

        }
    }
}

