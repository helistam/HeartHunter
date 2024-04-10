package com.example.herathunter

import MainScreen
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.herathunter.screens.LoginScreen
import com.example.herathunter.screens.PostOfficeApp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("my","start gui")
        super.onCreate(savedInstanceState)
        setContent {
           /* LazyColumn (){//элементы во время скрола остаются на том же месте
               items(count=10){
                   ListItem("Name","Surname")
               }
            }*/

            Log.e("my","start gui")
            //PostOfficeApp()
            var currentTheme by remember { mutableStateOf(Theme.Light) }
            Log.d("MyLog", "Current theme: $currentTheme")
            MaterialTheme(
                colorScheme = if (currentTheme == Theme.Light) lightColorScheme() else darkColorScheme(),
                content = {
                    PostOfficeApp(currentTheme) { newTheme ->
                        Log.d("MyLog", "New theme: $newTheme")
                        currentTheme = newTheme
                    }
                }
            )

            //MainScreen()

        }
    }
}

