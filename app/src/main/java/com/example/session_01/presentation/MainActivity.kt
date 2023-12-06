package com.example.session_01.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.session_01.R
import com.example.session_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initValues()
    }

    private fun initValues(){

    }
}