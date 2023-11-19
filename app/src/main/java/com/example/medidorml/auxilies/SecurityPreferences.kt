package com.example.medidorml.auxilies

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Consumer", Context.MODE_PRIVATE )

    fun storeValue(key: String, value: String){
        security.edit().putString(key, value).apply()
    }

    fun getValue(key: String) : String{
        return security.getString(key, "0") ?: "0"
    }

}