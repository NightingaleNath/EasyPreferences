package com.codelytical.easypreferences

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object EasyPreferences {
	private const val PREFERENCE_FILE_NAME = "easy_preferences"

	// Shared Preferences instance
	lateinit var preferences: SharedPreferences
	lateinit var gson: Gson

	// Initialize EasyPreferences with the application context
	fun initialize(context: Context) {
		preferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
		gson = Gson()
	}


	fun putString(key: String, value: String) {
		preferences.edit().putString(key, value).apply()
	}

	fun getString(key: String, defaultValue: String): String {
		return preferences.getString(key, defaultValue) ?: defaultValue
	}

	fun putBoolean(key: String, value: Boolean) {
		preferences.edit().putBoolean(key, value).apply()
	}

	fun getBoolean(key: String, defaultValue: Boolean): Boolean {
		return preferences.getBoolean(key, defaultValue)
	}

	fun putInt(key: String, value: Int) {
		preferences.edit().putInt(key, value).apply()
	}

	fun getInt(key: String, defaultValue: Int): Int {
		return preferences.getInt(key, defaultValue)
	}

	fun putFloat(key: String, value: Float) {
		preferences.edit().putFloat(key, value).apply()
	}

	fun getFloat(key: String, defaultValue: Float): Float {
		return preferences.getFloat(key, defaultValue)
	}

	fun putLong(key: String, value: Long) {
		preferences.edit().putLong(key, value).apply()
	}

	fun getLong(key: String, defaultValue: Long): Long {
		return preferences.getLong(key, defaultValue)
	}

	fun putStringSet(key: String, value: Set<String>) {
		preferences.edit().putStringSet(key, value).apply()
	}

	fun getStringSet(key: String, defaultValue: Set<String>): Set<String> {
		return preferences.getStringSet(key, defaultValue) ?: defaultValue
	}

	fun <T> putObject(key: String, value: T) {
		val jsonString = gson.toJson(value)
		preferences.edit().putString(key, jsonString).apply()
	}

	inline fun <reified T> getObject(key: String, defaultValue: T? = null): T? {
		val jsonString = preferences.getString(key, null)
		return if (jsonString != null) {
			gson.fromJson(jsonString, object : TypeToken<T>() {}.type)
		} else {
			defaultValue
		}
	}

	fun remove(key: String) {
		preferences.edit().remove(key).apply()
	}
}
