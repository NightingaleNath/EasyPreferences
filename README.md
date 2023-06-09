# **Android Easy Preferences**

[![](https://jitpack.io/v/NightingaleNath/EasyPreferences.svg)](https://jitpack.io/#NightingaleNath/EasyPreferences)


# **EasyPreferences**

"EasyPreferences" is a library that simplifies the process of handling shared preferences in Android applications. It provides an easy-to-use API for storing and retrieving key-value pairs in shared preferences, reducing the boilerplate code required for such operations

A simple easy to use library that helps you quickly store and retrive data from shared preferences

**Supporting Android Easy Preferences**

Android Easy Preferences is an independent project with ongoing development and support made possible

**How to integrate into your app**

Integrating the library into you app is extremely easy. A few changes in the build gradle and your all ready to use. Make the following changes.

Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

```
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```

Step 2. Add the dependency

```
dependencies {
   implementation 'com.github.NightingaleNath:EasyPreferences:<latest-version>'
}
```

**How to use the library**
Nice seems like you integrated the library in your project but how do you use it? Well its really easy just follow the steps below.

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize EasyPreferences
        EasyPreferences.initialize(this)

        // Example usage of putString and getString
        EasyPreferences.putString("name", "John Doe")
        val name = EasyPreferences.getString("name", "")
        Log.d("MainActivity", "Name: $name")

        // Example usage of putBoolean and getBoolean
        EasyPreferences.putBoolean("isDarkMode", true)
        val isDarkMode = EasyPreferences.getBoolean("isDarkMode", false)
        Log.d("MainActivity", "Is Dark Mode enabled: $isDarkMode")

        // Example usage of putInt and getInt
        EasyPreferences.putInt("age", 25)
        val age = EasyPreferences.getInt("age", 0)
        Log.d("MainActivity", "Age: $age")

        // Example usage of putFloat and getFloat
        EasyPreferences.putFloat("rating", 4.5f)
        val rating = EasyPreferences.getFloat("rating", 0.0f)
        Log.d("MainActivity", "Rating: $rating")

        // Example usage of putLong and getLong
        EasyPreferences.putLong("timestamp", System.currentTimeMillis())
        val timestamp = EasyPreferences.getLong("timestamp", 0L)
        Log.d("MainActivity", "Timestamp: $timestamp")

        // Example usage of putStringSet and getStringSet
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

        // Example usage of remove
        EasyPreferences.remove("age")
        val removedAge = EasyPreferences.getInt("age", 0)
        Log.d("MainActivity", "Removed Age: $removedAge")
    }
}

data class User(val name: String, val age: Int, val email: String)
```

That's all. Looks like your all done here.

## Author

Developed and Maintained by ([Nathaniel Nkrumah](https://github.com/NightingaleNath/EasyPreferences))


