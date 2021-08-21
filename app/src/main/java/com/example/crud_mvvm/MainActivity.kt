package com.example.crud_mvvm

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud_mvvm.Adapter.UserRecyclerViewAdapter
import com.example.crud_mvvm.databinding.ActivityMainBinding
import com.example.crud_mvvm.db.UserDatabase
import com.example.crud_mvvm.repository.UserRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserviewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = UserDatabase.getInstance(application).userDao

        val repo = UserRepository(dao)

        val factory = UserViewModelFactory(repo)

        userViewModel = ViewModelProvider(this, factory).get(UserviewModel::class.java)

        binding.myViewModel = userViewModel
        binding.lifecycleOwner = this

        binding.addBtn.setOnClickListener { v ->
            userViewModel.saveOrUpdate()
            val iMm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            iMm.hideSoftInputFromWindow(v.windowToken, 0)
            v.clearFocus()
        }
        initRecyclerview()
    }

    private fun initRecyclerview() {
        binding.userRecycler.layoutManager = LinearLayoutManager(this)
        displayUsers()
    }

    private fun displayUsers() {
        userViewModel.users.observe(this, Observer {
            Log.i("Mytag", it.toString())
            binding.userRecycler.adapter = UserRecyclerViewAdapter(it)
        })
    }


}