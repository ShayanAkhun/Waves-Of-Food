package com.example.wavesoffood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wavesoffood.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
      binding.detailsBackButton.setOnClickListener {
         
      }
        setContentView(binding.root)
        val foodName  = intent.getStringExtra("MenuItems")
        val foodImage  = intent.getIntExtra("MenuItemImage",0)
        binding.detailsFoodName.text =foodName
        binding.detailFoodImageView.setImageResource(foodImage)

    }
}