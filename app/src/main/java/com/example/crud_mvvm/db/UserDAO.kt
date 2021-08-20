package com.example.crud_mvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(user:User)

    @Update
    suspend fun updateUser(user:User)

    @Delete
    suspend fun deleteUser(user:User)

    @Query("Delete from user_data_table")
    suspend fun deleteAll()

    @Query("Select * from user_data_table")
    fun getUsers():LiveData<List<User>>
}