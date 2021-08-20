package com.example.crud_mvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1)
abstract  class UserDatabase:RoomDatabase() {

    abstract val userDao:UserDAO

    //singleton
    companion object{
        @Volatile
        private var INSTANCE : UserDatabase?=null

        fun getInstance(context: Context):UserDatabase{
            synchronized(this)
            {
                var instance:UserDatabase?= INSTANCE

                if(instance==null)
                {
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "User_data_database"
                    ).build()
                }
                return instance

            }
        }


    }



}