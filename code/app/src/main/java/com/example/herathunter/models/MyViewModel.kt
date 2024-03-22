package com.example.herathunter.models

import androidx.lifecycle.ViewModel
import com.example.herathunter.services.AppService
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

object MyViewModel : ViewModel() {


         fun postUser(user: User) {
             viewModelScope.launch {
                 AppService.postUser(user)
             }
        }



}