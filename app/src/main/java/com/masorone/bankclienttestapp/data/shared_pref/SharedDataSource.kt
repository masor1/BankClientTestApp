package com.masorone.bankclienttestapp.data.shared_pref

import android.content.Context
import android.content.SharedPreferences

interface SharedDataSource {
    fun save(id: Int)
    fun fetch(): Int

    class Base(private val context: Context) : SharedDataSource {
        private val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

        override fun save(id: Int) = sharedPreferences.edit().putInt(ID, id).apply()
        override fun fetch() = sharedPreferences.getInt(ID, 0)
    }

    private companion object {
        const val SHARED_PREF_NAME = "shared_pref"
        const val ID = "id"
    }
}