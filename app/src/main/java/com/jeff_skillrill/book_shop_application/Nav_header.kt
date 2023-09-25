package com.jeff_skillrill.book_shop_application

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.jeff_skillrill.book_shop_application.databinding.NavHeaderBinding
import com.jeff_skillrill.book_shop_application.model.User


class Nav_header : Fragment() {
    lateinit var shared: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NavHeaderBinding.inflate(inflater, container, false)



        shared = requireContext().getSharedPreferences("shared", AppCompatActivity.MODE_PRIVATE)
        val gson = Gson()
        val userJson = shared.getString("active_user", null)
        val user: User = gson.fromJson(userJson, User::class.java)

        binding.personNamen.text = user.username
        binding.personEmailn.text = user.email

        return binding.root
    }


}
