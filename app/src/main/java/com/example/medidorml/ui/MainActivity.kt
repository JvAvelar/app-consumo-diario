
package com.example.medidorml.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.medidorml.R
import com.example.medidorml.auxilies.Constants
import com.example.medidorml.auxilies.SecurityPreferences
import com.example.medidorml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var click = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Eventos de click
        binding.btn200ml.setOnClickListener(this)
        binding.btn500ml.setOnClickListener(this)
        binding.btn700ml.setOnClickListener(this)
        binding.btnClearAll.setOnClickListener(this)


    }

    override fun onResume() {
        super.onResume()
        startValueDefault()

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_200ml -> {
                click200ml()
            }
            R.id.btn_500ml -> {
                click500ml()
            }
            R.id.btn_700ml -> {
                click700ml()
            }
            R.id.btn_clear_all -> {
                clearAll()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun startValueDefault(){
        val value = SecurityPreferences(this).getValue(Constants.STR.MLS)
        binding.textOutput.text = "Hoje ${value}ml"
    }

    @SuppressLint("SetTextI18n")
    private fun clearAll(){
        val zero = "0"
        SecurityPreferences(this).storeValue(Constants.STR.MLS, zero)
        val value = SecurityPreferences(this).getValue(Constants.STR.MLS).toInt()
        binding.textOutput.text = "Hoje ${value}ml"
    }

    @SuppressLint("SetTextI18n")
    private fun click200ml(){
        val value = SecurityPreferences(this).getValue(Constants.STR.MLS).toInt()
        click = value + Constants.ML.ML200
        val click200 = click.toString()
        SecurityPreferences(this).storeValue(Constants.STR.MLS, click200)
        binding.textOutput.text = "Hoje ${click200}ml"
    }

    @SuppressLint("SetTextI18n")
    private fun click500ml(){
        val value = SecurityPreferences(this).getValue(Constants.STR.MLS).toInt()
        click = value + Constants.ML.ML500
        val click500 = click.toString()
        SecurityPreferences(this).storeValue(Constants.STR.MLS, click500)
        binding.textOutput.text = "Hoje ${click500}ml "
    }

    @SuppressLint("SetTextI18n")
    private fun click700ml(){
        val value = SecurityPreferences(this).getValue(Constants.STR.MLS).toInt()
        click = value + Constants.ML.ML700
        val click700 = click.toString()
        SecurityPreferences(this).storeValue(Constants.STR.MLS, click700)
        binding.textOutput.text = "Hoje ${click700}ml "
    }


}