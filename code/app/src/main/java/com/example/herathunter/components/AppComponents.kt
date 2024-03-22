package com.example.herathunter.components

import android.graphics.Paint.Style
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.herathunter.R
import com.example.herathunter.models.MyViewModel
import com.example.herathunter.models.User
import com.example.herathunter.screens.PostOfficeAppRouter
import com.example.herathunter.screens.Screen
import com.example.herathunter.services.AppService
import java.nio.file.WatchEvent
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@Composable
fun NormalTextComponent(value:String){
    Text(
        text=value,
        modifier= Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle= FontStyle.Normal
        )
        ,color= colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}
@Composable
fun HeadingTextComponent(value:String){
    Text(
        text=value,
        modifier= Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle= FontStyle.Normal
        )
        ,color= colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextFieldComponent(labelValue: String,painterResource:Painter): MutableState<String> {

    val textValue= remember{
         mutableStateOf("")
    }


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor =  colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            backgroundColor= colorResource(id = R.color.First_Name)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine=true,
        maxLines=1,
        value = textValue.value,  // Используйте .value, если textValue - это MutableState<String>
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        }
    )
    return textValue
}

@Composable
fun PasswordTextFieldComponent(labelValue: String,painterResource:Painter): MutableState<String>{

    val localFocusManager= LocalFocusManager.current
    val password= remember{
        mutableStateOf("")
    }

    val passwordVisible= remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor =  colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            backgroundColor= colorResource(id = R.color.First_Name)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine=true,
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        },
        maxLines=1,
        value = password.value,  // Используйте .value, если textValue - это MutableState<String>
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        },
        trailingIcon = {
            val iconImage=if(passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            var description =if(passwordVisible.value)
            {
                stringResource(id =R.string.hide_password )
            }else
            {
                stringResource(id =R.string.show_password )
            }
            IconButton(onClick = {passwordVisible.value=!passwordVisible.value}) {
                Icon(imageVector = iconImage,contentDescription = description)
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
    return password
}

@Composable
fun CheckboxComponent(value: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp)
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        val checkedState= remember {
           mutableStateOf(false)
        }
        Checkbox(checked =checkedState.value ,
            onCheckedChange = {
                checkedState.value != checkedState.value
            })
        Text(
            text=value,
            modifier= Modifier
                .fillMaxWidth()
                .heightIn(min = 20.dp),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontStyle= FontStyle.Normal
            )
            ,color= colorResource(id = R.color.colorText),
            textAlign = TextAlign.Left
        )
    }
}
@Composable
fun PhotoButton(value: String){
    Button(onClick = { PostOfficeAppRouter.navigateTo(Screen.MainScreen)},
        modifier= Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding= PaddingValues(),
        colors=ButtonDefaults.buttonColors(Color.Blue)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Red,
                            Color.Yellow
                        )
                    ),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Composable
fun ButtonComponent(value: String, user:User){
    Button(onClick = {

        Log.e("my","button")
        MyViewModel.postUser(user)
        //AppService.postUser(user)
        PostOfficeAppRouter.navigateTo(Screen.MainScreen)
                     },
        modifier= Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding= PaddingValues(),
        colors=ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Magenta,
                            Color.Cyan
                        )
                    ),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun DividerTextComponent(){
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color= Color(0xFF7B6F72),
            thickness = 1.dp
            )

        Text(text="or",fontSize=18.sp)

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color= Color(0xFF7B6F72),
            thickness = 1.dp
        )
    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin:Boolean=true,onTextSelected:(String)->Unit){
    val initialText=if(tryingToLogin)"Already have an account?" else "Don't have an account yet?"
    val loginText=if(tryingToLogin) "Login" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color(R.color.colorPrimary))){
            pushStringAnnotation(tag=loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(
        modifier= Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle= FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text =annotatedString , onClick ={offset->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also { span->
                Log.d("new window","{${span.item}}")
                if(span.item==loginText){
                    onTextSelected(span.item)
                }
            }
    } )
}