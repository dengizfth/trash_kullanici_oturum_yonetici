package com.fatihden.kullancoturumynetenbasitbiruygulama

import android.content.Context
import android.content.SharedPreferences

object SessionManager {
    private const val PREF_NAME = "user_session"
    private const val KEY_USER_ID = "user_id"
    private const val KEY_USER_NAME = "user_name"
    private const val KEY_IS_LOGGED_IN = "is_logged_in"

    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    fun init(context : Context) {
        sharedPreferences = context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )

        editor = sharedPreferences.edit()
    }

    fun createLoginSession(userId:Int , userName:String){
        editor.putInt(KEY_USER_ID,userId)
        editor.putString(KEY_USER_NAME,userName)
        editor.putBoolean(KEY_IS_LOGGED_IN,true)
        editor.apply()
    }

    fun logout() {
        editor.clear()
        editor.apply()
    }

    val isLoggedIn : Boolean
        get() = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN,false)
    val userId : Int
        get() = sharedPreferences.getInt(KEY_USER_ID,-1)
    val userName : String?
        get() = sharedPreferences.getString(KEY_USER_NAME,null)



}