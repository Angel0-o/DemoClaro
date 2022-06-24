package com.moragar.democlaro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moragar.democlaro.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Container : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_main)
    }
}