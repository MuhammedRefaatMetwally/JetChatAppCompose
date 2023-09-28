package com.example.jetchatappcompose.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.jetchatappcompose.navigation.ChatScreens
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashViewModel : ViewModel() {

    fun redirect(navController: NavHostController) {
        if(Firebase.auth.currentUser == null){
            navController.navigate(ChatScreens.LoginScreen.name)
            return
        }
        navController.navigate(ChatScreens.HomeScreen.name)

    }
}