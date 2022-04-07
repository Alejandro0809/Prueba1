package com.example.prueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba.databinding.EscanerBinding
import com.google.zxing.integration.android.IntentIntegrator

class EscanerClass : AppCompatActivity() {

    private lateinit var binding: EscanerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= EscanerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnScan.setOnClickListener{ initScanner()}


    }

    private fun initScanner(){
        IntentIntegrator(this).initiateScan()
    }
}