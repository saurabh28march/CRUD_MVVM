package com.example.crud_mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.crud_mvvm.repository.UserRepository

class UserViewModelFactory(private val userRepo:UserRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserviewModel::class.java))
        {
            return UserviewModel(userRepo) as T
        }

       throw IllegalMonitorStateException("Invalid view model class")

    }
}