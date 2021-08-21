package com.example.crud_mvvm.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_mvvm.R
import com.example.crud_mvvm.databinding.ListItemBinding
import com.example.crud_mvvm.db.User

class UserRecyclerViewAdapter(private val users: List<User>) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutinflater = LayoutInflater.from(parent.context)

        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutinflater, R.layout.list_item,parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User) {
        binding.nameTextView.text = user.name
        binding.emailTextView.text = user.email
        binding.hobbyTextView.text = user.hobby
    }
}
