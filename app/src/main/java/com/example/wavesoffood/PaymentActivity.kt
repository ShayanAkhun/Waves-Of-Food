package com.example.wavesoffood

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wavesoffood.databinding.ActivityPaymentBinding
import com.example.wavesoffood.fragments.CongratsBottomSheet

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButton.setOnClickListener {  finish() }
        binding.placemyorderbutton.setOnClickListener{
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager, "test")
        }
    }
}