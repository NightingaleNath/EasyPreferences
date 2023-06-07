package com.codelytical.easypreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		EasyPreferences.initialize(this)

//		EasyPreferences.putString("username", "JohnDoe")
//
//		val username = EasyPreferences.getString("username", "")
//
//		Toast.makeText(this, username, Toast.LENGTH_LONG).show()

//		val user = User("John Doe", 30)
//
//		// Store the User object in preferences
//		EasyPreferences.putObject("user", user)
//
//		// Retrieve the User object from preferences
//		val retrievedUser = EasyPreferences.getObject<User>("user")
//
//		if (retrievedUser != null) {
//			Toast.makeText(this, "Retrieved User: ${retrievedUser.name}, ${retrievedUser.age}\"", Toast.LENGTH_LONG).show()
//		} else {
//			Toast.makeText(this, "User object not found", Toast.LENGTH_LONG).show()
//		}

		// Create a list of users
		val userList = listOf(
			User("John Doe", 30),
			User("Jane Smith", 25),
			User("Bob Johnson", 35)
		)

		// Store the list of users in preferences
		EasyPreferences.putObject("userList", userList)

		// Retrieve the list of users from preferences
		val retrievedUserList = EasyPreferences.getObject<List<User>>("userList")

		// Check if the list of users was retrieved successfully
		if (retrievedUserList != null) {
			// Iterate over the retrieved list of users
			for (user in retrievedUserList) {
				Toast.makeText(this, "Retrieved User: ${user.name}, ${user.age}", Toast.LENGTH_LONG).show()

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