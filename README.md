# MaterialUtils
Material Util Project Demo

## Get Started
Add it in your root build.gradle at the end of repositories:

```bash
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }	
	}
}
```
Add the dependency

```bash
dependencies {
	implementation 'com.github.dutchmanbd:materialutils:0.1.0'
}
```

### How to use

Suppose you have some views like TextView, ProgressBar. TextView id is tvName and ProgressBar is is pbMain.
You can easily show and hide those views using following code:

### Show views:
tvName.show()
pbMain.show()

### Hide views:
tvName.hide()
pbMain.hide()

### Init SharedPreference Util
val sharedPref = SharedPref(context)

### Read data from sharedPref

val name = sharedPref.read(YOUR_KEY, DEFAULT_VALUE) 

### DEFAULT_VALUE must be String, Int, Boolean

### Example
```
String
val name: String = sharedPref.read(YOUR_KEY, "")
Int
val name: Int = sharedPref.read(YOUR_KEY, 0)
Boolean
val name: Boolean = sharedPref.read(YOUR_KEY, false)
```
