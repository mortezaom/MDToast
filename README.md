# MDToast - MaterialDesign Toast

![](https://img.shields.io/github/stars/mortezaom/MDToast.svg) ![](https://img.shields.io/github/v/release/mortezaom/MDToast)

A lightweight Toast library written with Kotlin inspired by [MDToast](https://github.com/valdesekamdem/MaterialDesign-Toast "MDToast") with Easy to use extensions for Kotlin developers and fully accessable for Java Developers. If you don't know how to use extension methods, first search about it :)

* **Info**

    ![Info Toast](https://raw.githubusercontent.com/valdesekamdem/MaterialDesign-Toast/master/images/info.png)
* **Success**
    
    ![Success Toast](https://raw.githubusercontent.com/valdesekamdem/MaterialDesign-Toast/master/images/success.png)
* **Warning**

    ![Warning Toast](https://raw.githubusercontent.com/valdesekamdem/MaterialDesign-Toast/master/images/warning.png)
* **Error**
    
    ![Error Toast](https://raw.githubusercontent.com/valdesekamdem/MaterialDesign-Toast/master/images/error.png)

* **Download Demo** [Link](https://github.com/mortezaom/MDToast/blob/main/app/release/app-release.apk "Link")

### Extentions
All these extensions available for Context class, and you can use it everywhere that context or activity instance is available ( or applicationContext ). see [examples](https://github.com/mortezaom/MDToast/blob/main/app/src/main/java/dev/mortezaom/example/MainActivity.kt "examples")

Extensions  | Usage
------------- | -------------
`Context.sToast(message)`  | Create an Android **default** short Toast
`Context.lToast(message)`  | Create an Android **default** long Toast
`Context.sInfoToast(message)`  | to show a short **Info** MDToast
`Context.lInfoToast(message)`  | to show a long **Info** MDToast
`Context.sWarningToast(message)`  | to show a short **Warning** MDToast
`Context.lWarningToast(message)`  | to show a long **Warning** MDToast
`Context.sSuccessToast(message)`  | to show a short **Success** MDToast
`Context.lSuccessToast(message)`  | to show a long **Success** MDToast
`Context.sErrorToast(message)`  | to show a short **Error** MDToast
`Context.lErrorToast(message)`  | to show a long **Error** MDToast

You can also create a fully customized MDToast with `Context.customMDToast(...)`

```
Context.customMDToast(
    message: String,
    duration: Int = MDToast.LENGTH_SHORT,
    type: Int = MDToast.TYPE_INFO,
    bgColor: Int? = null,
    icon: Drawable? = null,
    borderRadius: Int? = null,
    elevation: Int? = null,
    typeface: Typeface? = null,
)
```

## Installation
Add jitpack maven link in your root build.gradle ( or settings.gradle base on your gradle version ) at the end of repositories:
```
repositories {
     ...
     maven { url 'https://jitpack.io' }
}
```
Add the dependency
```
dependencies {
     ...
     implementation 'com.github.mortezaom:MDToast:1.0.0'
}
```
Now you can use MDToast and extensions in your project.

## For Java Language Developers

However the extensions are not usable in java language, still you can use `MDToast.makeText(...)` method in your codes. ( don't forgot to call `show()` method  )

```
MDToast.makeText(this, message, MDToast.LENGTH_SHORT, MDToast.TYPE_INFO).show()
```
**Types**:` MDToast.TYPE_INFO`, `MDToast.TYPE_WARNING`, `MDToast.TYPE_SUCCESS`, `MDToast.TYPE_ERROR`

**Durations**:` MDToast.LENGTH_SHORT`, `MDToast.LENGTH_LONG`

You can also create a fully customized Toast:
```
MDToast.makeText(
     Context context,
     String message,
     int duration = LENGTH_SHORT,      
     int type = TYPE_INFO,
     int bgColor = null,
     Drawable tIcon = null,
     int borderRadius = null,
     int elevation = null,
     Typeface typeface = null
).show()
```
You can enter your custom values instead of each parameters or send null to them, also you can use setters method to change the values for each items.


### Contributing
If you can add new things, You are welcome ! you can have pull requests :)
Or if there is any question or error you can open a new issue.
I will happy to see more **stars** if you like this :)

### Contributors
MortezaOM - mortezamohammady56@gmail.com

### The End :)
