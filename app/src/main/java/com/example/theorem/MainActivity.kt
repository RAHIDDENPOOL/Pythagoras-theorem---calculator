package com.example.theorem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.theorem.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onClickResult(view : View) {
        if (!isFieldEmpty()) {
            val result = getString(R.string.resultOverall) + gerResult()
            binding.resultTxt.text = result
        }
    }
    private fun isFieldEmpty(): Boolean{
        binding.apply {
            if (edTxtA.text.isNullOrEmpty()) edTxtA.error = getString(R.string.errorMsg)
            if (edTxtB.text.isNullOrEmpty()) edTxtB.error = getString(R.string.errorMsg)
            return edTxtA.text.isNullOrEmpty() || edTxtB.text.isNullOrEmpty()
        }
    }
    private fun gerResult(): String{
        val a: Double
        val b: Double
    binding.apply {
        a = edTxtA.text.toString().toDouble()
        b = edTxtB.text.toString().toDouble()
    }
        return sqrt(  ( a.pow(2) + b.pow(2) )  ).toString()
    }
}