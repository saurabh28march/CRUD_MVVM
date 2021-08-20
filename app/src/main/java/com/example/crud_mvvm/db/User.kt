package com.example.crud_mvvm.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.StringBuilder

//Table Name
@Entity(tableName = "user_data_table")
data class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="user_id")
    val id: Int,

    @ColumnInfo(name="user_name")
    val name: String,

    @ColumnInfo(name="user_email")
    val email: String,

    @ColumnInfo(name="user_hobby")
    val hobby: String

)