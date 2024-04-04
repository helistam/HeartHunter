package com.example.herathunter.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.herathunter.App.PostOfficeApp
import com.example.herathunter.R
import com.example.herathunter.components.ButtonComponent
import com.example.herathunter.components.ClickableLoginTextComponent
import com.example.herathunter.components.DividerTextComponent
import com.example.herathunter.components.HeadingTextComponent
import com.example.herathunter.components.MyTextFieldComponent
import com.example.herathunter.components.NormalTextComponent
import com.example.herathunter.components.PasswordTextFieldComponent
import com.example.herathunter.models.User

@Composable
fun LoginScreen(){
    Surface (
        color= Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id=R.string.welcome))
            val emailState = MyTextFieldComponent(
                labelValue= stringResource(id = R.string.email),
                painterResource(id = R.drawable.emails)
            )
            val passwordState = PasswordTextFieldComponent(
                labelValue= stringResource(id = R.string.password),
                painterResource(id = R.drawable.lock)
            )
            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(value = stringResource(id = R.string.login), user = User(2,"","","","","","","","", confirmed = false, available = true
            )
            )
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected ={
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            } )
        }
       }
}
@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}