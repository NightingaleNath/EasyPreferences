package com.codelytical.easypreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		EasyPreferences.initialize(this)

		// Example usage of putString and getString
		EasyPreferences.putString("name", "John Doe")
		val name = EasyPreferences.getString("name", "")
		Toast.makeText(this, "Name: $name", Toast.LENGTH_LONG).show()
		Log.d("MainActivity", "Name: $name")

		// Example usage of putBoolean and getBoolean
		EasyPreferences.putBoolean("isDarkMode", true)
		val isDarkMode = EasyPreferences.getBoolean("isDarkMode", false)
		Toast.makeText(this, "Is Dark Mode enabled: $isDarkMode", Toast.LENGTH_LONG).show()
		Log.d("MainActivity", "Is Dark Mode enabled: $isDarkMode")

		// Example usage of putInt and getInt
		EasyPreferences.putInt("age", 25)
		val age = EasyPreferences.getInt("age", 0)
		Toast.makeText(this, "Age: $age", Toast.LENGTH_LONG).show()
		Log.d("MainActivity", "Age: $age")

		// Example usage of putFloat and getFloat
		EasyPreferences.putFloat("rating", 4.5f)
		val rating = EasyPreferences.getFloat("rating", 0.0f)
		Toast.makeText(this, "Rating: $rating", Toast.LENGTH_LONG).show()
		Log.d("MainActivity", "Rating: $rating")

		// Example usage of putLong and getLong
		EasyPreferences.putLong("timestamp", System.currentTimeMillis())
		val timestamp = EasyPreferences.getLong("timestamp", 0L)
		Toast.makeText(this, "Timestamp: $timestamp", Toast.LENGTH_LONG).show()
		Log.d("MainActivity", "Timestamp: $timestamp")

		// Create a set of strings
		val stringSet = setOf("Apple", "Banana", "Orange")

		// Store the set of strings in preferences
		EasyPreferences.putStringSet("fruits", stringSet)

		// Retrieve the set of strings from preferences
		val retrievedStringSet = EasyPreferences.getStringSet("fruits", emptySet())

		// Check if the set of strings was retrieved successfully
		if (retrievedStringSet.isNotEmpty()) {
			// Iterate over the retrieved set of strings
			for (fruit in retrievedStringSet) {
				Toast.makeText(this, "Retrieved Fruit: $fruit", Toast.LENGTH_LONG).show()
				Log.d("MainActivity", "Retrieved Fruit: $fruit")
			}
		} else {
			Toast.makeText(this, "Fruit set not found", Toast.LENGTH_LONG).show()
			Log.d("MainActivity", "Fruit set not found")
		}

		// Store the User object in preferences
		val user = User("John Doe", 25, "john.doe@example.com");
		EasyPreferences.putObject("user", user)

		// Retrieve the User object from preferences
		val retrievedUser = EasyPreferences.getObject<User>("user")

		if (retrievedUser != null) {
			Toast.makeText(this, "Retrieved User: ${retrievedUser.name}, ${retrievedUser.age}", Toast.LENGTH_LONG).show()
		} else {
			Toast.makeText(this, "User object not found", Toast.LENGTH_LONG).show()
		}

		// Create a list of users
		val userList = listOf(
			User("John Doe", 25, "john.doe@example.com"),
			User("Jane Smith", 20, "jane@example.com"),
			User("Bob Johnson", 30, "bob@example.com")
		)

		// Store the list of users in preferences
		EasyPreferences.putObject("userList", userList)

		// Retrieve the list of users from preferences
		val retrievedUserList = EasyPreferences.getObject<List<User>>("userList")

		// Check if the list of users was retrieved successfully
		if (retrievedUserList != null) {
			// Iterate over the retrieved list of users
			for (users in retrievedUserList) {
				Toast.makeText(this, "Retrieved User: ${users.name}, ${users.age}", Toast.LENGTH_LONG).show()

			}
			Toast.makeText(this, "Retrieved User Length: ${retrievedUserList.size}", Toast.LENGTH_LONG).show()
		} else {
			Toast.makeText(this, "User list not found", Toast.LENGTH_LONG).show()
		}

//		EasyPreferences.remove("username")
//		val removedUsername = EasyPreferences.getString("username", "")
//		Toast.makeText(this, removedUsername, Toast.LENGTH_LONG).show()
	}
}