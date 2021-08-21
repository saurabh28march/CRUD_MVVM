package com.example.crud_mvvm

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud_mvvm.db.User
import com.example.crud_mvvm.repository.UserRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserviewModel(private val userRepo: UserRepository) : ViewModel() {

    val users=userRepo.users

    @Bindable
    val user_name = MutableLiveData<String>()

    @Bindable
    val user_email = MutableLiveData<String>()

    @Bindable
    val user_hobby = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()
    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear ALL"
    }

    fun saveOrUpdate()
    {
        val name=user_name.value!!
        val email=user_email.value!!
        val hobby=user_hobby.value!!

        insert(User(0,name,email,hobby))

        user_name.value=null
        user_email.value=null
        user_hobby.value=null

    }

    fun clearOrDelete()
    {
       deleteAll()
    }

    fun insert(user: User) : Job =
      viewModelScope.launch {
          userRepo.insert(user)
    }

    fun delete(user:User):Job = viewModelScope.launch {
        userRepo.delete(user)
    }


    fun update(user:User):Job =viewModelScope.launch {
        userRepo.update(user)
    }

    fun deleteAll() : Job =viewModelScope.launch {
        userRepo.deleteAll();
    }





}