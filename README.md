# MaterialUtils
[![Build Status](https://travis-ci.org/dutchmanbd/materialutils.svg?branch=master)](https://travis-ci.org/dutchmanbd/materialutils)
[![GitHub issues](https://img.shields.io/github/issues/dutchmanbd/materialutils)](https://github.com/dutchmanbd/materialutils/issues)

Material Util Project

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
## View Extensions

### How to use

Suppose you have some views like as TextView, ProgressBar. If TextView ID is tvName and ProgressBar ID is pbMain.
Then you can easily show and hide those views using following code:

#### Show views:
```
tvName.show()
pbMain.show()
```

#### Hide views:
```
tvName.hide()
pbMain.hide()
```
## Context Extension
### Show toast from activity
```
toast("Your message here")
```
### Show Toast from fragment

```
context?.toast("Your message here")
```
## SharedPreference

### Init SharedPref
val sharedPref = SharedPref(context)

### Read data from sharedPref

val name = sharedPref.read(YOUR_KEY, DEFAULT_VALUE) 

### DEFAULT_VALUE must be String, Int, Boolean

#### Example
```
String
val name: String = sharedPref.read(YOUR_KEY, "")
Int
val id: Int = sharedPref.read(YOUR_KEY, 0)
Boolean
val isAvailable: Boolean = sharedPref.read(YOUR_KEY, false)
```
### Write data to sharedPref

sharedPref.write(YOUR_KEY, "dutchman")

#### Example
```
String
sharedPref.write(YOUR_KEY, "dutchman")
Int
sharedPref.write(YOUR_KEY, 704)
Boolean
sharedPref.write(YOUR_KEY, true)
```
