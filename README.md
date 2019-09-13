# MaterialUtils
[![Build Status](https://travis-ci.org/dutchmanbd/materialutils.svg?branch=master)](https://travis-ci.org/dutchmanbd/materialutils)
[![GitHub issues](https://img.shields.io/github/issues/dutchmanbd/materialutils)](https://github.com/dutchmanbd/materialutils/issues)

Material Util Project Demo

## Get Started
Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }	
	}
}
```
Add the dependency

```
dependencies {
	implementation 'com.github.dutchmanbd:materialutils:0.1.0'
}
```

### How to use

Suppose you have some views like TextView, ProgressBar. TextView id is tvName.
You can easily show and hide those views using following code:

### Show views:
tvName.show()

### Hide views:
tvName.hide()

### Init SharedPreference Util
val sharedPref = SharedPref(context)

### Read data from sharedPref

val name = sharedPref.read(YOUR_KEY, DEFAULT_VALUE) 

### DEFAULT_VALUE must be String, Int, Boolean

#### Example
```
String
val name: String = sharedPref.read(YOUR_KEY, "")
Int
val name: Int = sharedPref.read(YOUR_KEY, 0)
Boolean
val name: Boolean = sharedPref.read(YOUR_KEY, false)
```
### Write data to sharedPref

sharedPref.write(YOUR_KEY, "Jewel")

#### Example
```
String
sharedPref.write(YOUR_KEY, "Jewel")
Int
sharedPref.write(YOUR_KEY, 704)
Boolean
sharedPref.write(YOUR_KEY, true)
```
