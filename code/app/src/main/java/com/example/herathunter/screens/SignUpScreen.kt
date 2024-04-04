package com.example.herathunter.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.herathunter.models.User
import com.example.herathunter.services.AppService

@Composable
fun SignUpScreen() {

    Log.e("my","start sign")
    Surface (
        color= Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){

        Log.e("my","sign")
        Column(modifier= Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            val firstNameState = MyTextFieldComponent(
                labelValue= stringResource(id = R.string.first_name),
                painterResource(id = R.drawable.icon),
            )
            Log.e("my","sign2")
            val dateOfBirthState = MyTextFieldComponent(
                labelValue= stringResource(id = R.string.date_of_birth),
                painterResource(id = R.drawable.date)
            )
            val emailState = MyTextFieldComponent(
                labelValue= stringResource(id = R.string.email),
                painterResource(id = R.drawable.emails)
            )


            val genderState = MyTextFieldComponent(
                labelValue= stringResource(id = R.string.gender),
                painterResource(id = R.drawable.gender)
            )
            val cityState = MyTextFieldComponent(
                labelValue= stringResource(id = R.string.city),
                painterResource(id = R.drawable.city)
            )


            val passwordState = PasswordTextFieldComponent(
                labelValue= stringResource(id = R.string.password),
                painterResource(id = R.drawable.lock)
            )
            Log.e("my","sign3")
            Spacer(modifier = Modifier.height(20.dp))
            PhotoButton(value= "Upload photo")
            CheckboxComponent(value = stringResource(id =R.string.terms_and_conditions ) )
            
            Spacer(modifier = Modifier.height(80.dp))
            val user = User(2,
                emailState.value,
                passwordState.value,
                firstNameState.value,
                dateOfBirthState.value,
                "",
                "",genderState.value,
                cityState.value,
                confirmed = false,
                available = true
            )
            ButtonComponent(value= stringResource(id = R.string.register), user)

            Spacer(modifier = Modifier.height(40.dp))
            DividerTextComponent()
            ClickableLoginTextComponent(tryingToLogin = true,onTextSelected={
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            })

            Log.e("my","sign fin")

            Log.e("my","sign fin fin")
        }
    }
}

 @Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}