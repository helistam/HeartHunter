package com.example.herathunter.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.herathunter.R
import com.example.herathunter.components.ButtonComponent
import com.example.herathunter.components.CheckboxComponent
import com.example.herathunter.components.ClickableLoginTextComponent
import com.example.herathunter.components.DividerTextComponent
import com.example.herathunter.components.HeadingTextComponent
import com.example.herathunter.components.MyTextFieldComponent
import com.example.herathunter.components.NormalTextComponent
import com.example.herathunter.components.PasswordTextFieldComponent
import com.example.herathunter.components.PhotoButton

@Composable
fun SignUpScreen() {
    Surface (
        color= Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(modifier= Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFieldComponent(
                labelValue= stringResource(id = R.string.first_name),
                painterResource(id = R.drawable.icon)
                )
            MyTextFieldComponent(
                labelValue= stringResource(id = R.string.last_name),
                painterResource(id = R.drawable.icon)
            )
            MyTextFieldComponent(
                labelValue= stringResource(id = R.string.email),
                painterResource(id = R.drawable.emails)
            )
            PasswordTextFieldComponent(
                labelValue= stringResource(id = R.string.password),
                painterResource(id = R.drawable.lock)
            )
            Spacer(modifier = Modifier.height(20.dp))
            PhotoButton(value= "Upload photo")
            CheckboxComponent(value = stringResource(id =R.string.terms_and_conditions ) )
            
            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(value= stringResource(id = R.string.register))

            Spacer(modifier = Modifier.height(40.dp))
            DividerTextComponent()
            ClickableLoginTextComponent(tryingToLogin = true,onTextSelected={
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            })
        }


    }
}

 @Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}