# MaterialUtils
Material Util Project Demo

How to use

Suppose you have some views like TextView, ProgressBar. TextView id is tvName and ProgressBar is is pbMain.
You can easily show and hide those views using following code:

# Show views:
tvName.show()
pbMain.show()

# Hide views:
tvName.hide()
pbMain.hide()

# Init SharedPreference Util
val sharedPref = SharedPref(context)

# Read data from sharedPref

val name = sharedPref.read(YOUR_KEY, DEFAULT_VALUE) 

# DEFAULT_VALUE must be String, Int, Boolean

# String
val name: String = sharedPref.read(YOUR_KEY, "")

# Int
val name: Int = sharedPref.read(YOUR_KEY, 0)
# Boolean
val name: Boolean = sharedPref.read(YOUR_KEY, false)
