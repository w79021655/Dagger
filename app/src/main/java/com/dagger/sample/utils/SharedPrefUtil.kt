package com.dagger.sample.utils

import android.content.Context

class SharedPrefUtil {
    private val KEY: String = "KEY"

    /**
     * Gets boolean data.
     *
     * @param context the context
     * @param key     the key
     * @return the boolean data
     */
    fun getBooleanData(context: Context, key: String?): Boolean {
        return context.getSharedPreferences(KEY, Context.MODE_PRIVATE).getBoolean(key, false)
    }

    /**
     * Gets int data.
     *
     * @param context the context
     * @param key     the key
     * @return the int data
     */
    fun getIntData(context: Context, key: String?): Int {
        return context.getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt(key, 0)
    }

    /**
     * Gets string data.
     *
     * @param context the context
     * @param key     the key
     * @return the string data
     */
    fun getStringData(context: Context, key: String?): String? {
        return context.getSharedPreferences(KEY, Context.MODE_PRIVATE).getString(key, null)
    }

    /**
     * Save data.
     *
     * @param context the context
     * @param key     the key
     * @param value   the value
     */
    fun saveStringData(context: Context, key: String?, value: String?) {
        context.getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(key, value)
            .apply()
    }

    /**
     * Save data.
     *
     * @param context the context
     * @param key     the key
     * @param value     the value
     */
    fun saveIntData(context: Context, key: String?, value: Int) {
        context.getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(key, value)
            .apply()
    }

    /**
     * Save data.
     *
     * @param context the context
     * @param key     the key
     * @param value     the value
     */
    fun saveBoooleanData(context: Context, key: String?, value: Boolean) {
        context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(key, value)
            .apply()
    }
}