package com.example.crud_mvvm.repository

import com.example.crud_mvvm.db.User
import com.example.crud_mvvm.db.UserDAO

class UserRepository(private val dao:UserDAO) {

    val users =dao.getUsers()

    suspend fun insert(user: User)
    {
        dao.insertUser(user)
    }


    suspend fun update(user:User)
    {
        dao.updateUser(user)
    }

    suspend fun delete(user: User)
    {
        dao.deleteUser(user)
    }

    suspend fun deleteAll()
    {
        dao.deleteAll()
    }




}