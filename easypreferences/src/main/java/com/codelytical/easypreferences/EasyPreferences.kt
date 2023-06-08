package com.codelytical.easypreferences

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object EasyPreferences {
	const val TAG = "EasyPreferences"
	private const val PREFERENCE_FILE_NAME = "easy_preferences"

	lateinit var preferences: SharedPreferences
	lateinit var gson: Gson

	fun initialize(context: Context) {
		preferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
		gson = Gson()
	}

	fun putString(key: String, value: String) {
		try {
			preferences.edit().putString(key, value).apply()
		} catch (e: Exception) {
			Log.e(TAG, "Error putting string preference with key: $key", e)
		}
	}

	fun getString(key: String, defaultValue: String): String {
		return try {
			preferences.getString(key, defaultValue) ?: defaultValue
		} catch (e: Exception) {
			Log.e(TAG, "Error getting string preference with key: $key", e)
			defaultValue
		}
	}

	fun putBoolean(key: String, value: Boolean) {
		try {
			preferences.edit().putBoolean(key, value).apply()
		} catch (e: Exception) {
			Log.e(TAG, "Error putting boolean preference with key: $key", e)
		}
	}

	fun getBoolean(key: String, defaultValue: Boolean): Boolean {
		return try {
			preferences.getBoolean(key, defaultValue)
		} catch (e: Exception) {
			Log.e(TAG, "Error getting boolean preference with key: $key", e)
			defaultValue
		}
	}

	fun putInt(key: String, value: Int) {
		try {
			preferences.edit().putInt(key, value).apply()
		} catch (e: Exception) {
			Log.e(TAG, "Error putting int preference with key: $key", e)
		}
	}

	fun getInt(key: String, defaultValue: Int): Int {
		return try {
			preferences.getInt(key, defaultValue)
		} catch (e: Exception) {
			Log.e(TAG, "Error getting int preference with key: $key", e)
			defaultValue
		}
	}

	fun putFloat(key: String, value: Float) {
		try {
			preferences.edit().putFloat(key, value).apply()
		} catch (e: Exception) {
			Log.e(TAG, "Error putting float preference with key: $key", e)
		}
	}

	fun getFloat(key: String, defaultValue: Float): Float {
		return try {
			preferences.getFloat(key, defaultValue)
		} catch (e: Exception) {
			Log.e(TAG, "Error getting float preference with key: $key", e)
			defaultValue
		}
	}

	fun putLong(key: String, value: Long) {
		try {
			preferences.edit().putLong(key, value).apply()
		} catch (e: Exception) {
			Log.e(TAG, "Error putting long preference with key: $key", e)
		}
	}

	fun getLong(key: String, defaultValue: Long): Long {
		return try {
			preferences.getLong(key, defaultValue)
		} catch (e: Exception) {
			Log.e(TAG, "Error getting long preference with key: $key", e)
			defaultValue
		}
	}

	fun putStringSet(key: String, value: Set<String>) {
		try {
			preferences.edit().putStringSet(key, value).apply()
		} catch (e: Exception) {
			Log.e(TAG, "Error putting string set preference with key: $key", e)
		}
	}

	fun getStringSet(key: String, defaultValue: Set<String>): Set<String> {
		return try {
			preferences.getStringSet(key, defaultValue) ?: defaultValue
		} catch (e: Exception) {
			Log.e(TAG, "Error getting string set preference with key: $key", e)
			defaultValue
		}
	}

	fun <T> putObject(key: String, value: T) {
		try {
			val jsonString = gson.toJson(value)
			preferences.edit().putString(key, jsonString).apply()
		} catch (e: Exception) {
			Log.e(TAG, "Error putting object preference with key: $key", e)
		}
	}

	inline fun <reified T> getObject(key: String, defaultValue: T? = null): T? {
		return try {
			val jsonString = preferences.getString(key, null)
			if (jsonString != null) {
				gson.fromJson(jsonString, object : TypeToken<T>() {}.type)
			} else {
				defaultValue
			}
		} catch (e: Exception) {
			Log.e(TAG, "Error getting object preference with key: $key", e)
			defaultValue
		}
	}

	fun remove(key: String) {
		try {
			preferences.edit().remove(key).apply()
		} catch (e: Exception) {
			Log.e(TAG, "Error removing preference with key: $key", e)
		}
	}
}
