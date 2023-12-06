package com.example.session_01.data.preference

import android.content.Context
import com.example.session_01.domain.entity.User
import com.google.gson.Gson

object PreferenceUser {
    val PREFERENCE_NAME = "PreferenceUser"
    val CLASS_NAME = "Usuario"

    fun setPreferenceUser(context: Context, user: User) : Int{
        val pref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        val gson = Gson()
        val usuarioJson = gson.toJson(user)
        editor.putString(CLASS_NAME, usuarioJson)
        editor.apply()
        return 1
    }

    fun getPreferenceUser(context: Context) : User?{
        var user : User? = null
        val pref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        if(pref.contains(CLASS_NAME)){
            val usuarioJson = pref.getString(CLASS_NAME, "")
            val gson = Gson()
            user = gson.fromJson(usuarioJson, User::class.java)
        }
        return user
    }

    fun deletePreferenceUser(context: Context){
        val pref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.apply()
    }
}