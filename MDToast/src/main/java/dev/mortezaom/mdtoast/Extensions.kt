package dev.mortezaom.mdtoast

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.widget.Toast

/**
 * Shortcut for creating Toast with Toast.makeText().show() with Short Length.
 * @param message  the message to show.
 */
fun Context.sToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * Shortcut for creating Toast with Toast.makeText().show() with Long Length.
 * @param message  the message to show.
 */
fun Context.lToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 * Shortcut for creating MDToast with Toast.makeText().show() with Short Length and Info type.
 * @param message  the message to show.
 */
fun Context.sInfoToast(message: String) {
    MDToast.makeText(this, message, MDToast.LENGTH_SHORT, MDToast.TYPE_INFO).show()
}

/**
 * Shortcut for creating MDToast with Toast.makeText().show() with Long Length and Info type.
 * @param message  the message to show.
 */
fun Context.lInfoToast(message: String) {
    MDToast.makeText(this, message, MDToast.LENGTH_LONG, MDToast.TYPE_INFO).show()
}

/**
 * Shortcut for creating MDToast with Toast.makeText().show() with Short Length and Warning type.
 * @param message  the message to show.
 */
fun Context.sWarningToast(message: String) {
    MDToast.makeText(this, message, MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING).show()
}

/**
 * Shortcut for creating MDToast with Toast.makeText().show() with Long Length and Warning type.
 * @param message  the message to show.
 */
fun Context.lWarningToast(message: String) {
    MDToast.makeText(this, message, MDToast.LENGTH_LONG, MDToast.TYPE_WARNING).show()
}

/**
 * Shortcut for creating MDToast with Toast.makeText().show() with Short Length and Success type.
 * @param message  the message to show.
 */
fun Context.sSuccessToast(message: String) {
    MDToast.makeText(this, message, MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS).show()
}

/**
 * Shortcut for creating MDToast with Toast.makeText().show() with Long Length and Success type.
 * @param message  the message to show.
 */
fun Context.lSuccessToast(message: String) {
    MDToast.makeText(this, message, MDToast.LENGTH_LONG, MDToast.TYPE_SUCCESS).show()
}

/**
 * Shortcut for creating MDToast with Toast.makeText().show() with Short Length and Error type.
 * @param message  the message to show.
 */

fun Context.sErrorToast(message: String) {
    MDToast.makeText(this, message, MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
}

/**
 * Shortcut for creating MDToast with Toast.makeText().show() with Long Length and Error type.
 * @param message  the message to show.
 */
fun Context.lErrorToast(message: String) {
    MDToast.makeText(this, message, MDToast.LENGTH_LONG, MDToast.TYPE_ERROR).show()
}

/**
 * Shortcut for creating a custom MDToast.
 * @param message  The message to show.
 * @param duration  Duration of Toast.
 * @param type  Type of Toast.
 * @param bgColor  The backgroundColor of Toast.
 * @param borderRadius  The borderRadius of Toast.
 * @param elevation  The elevation of Toast.
 */
fun Context.customMDToast(
    message: String,
    duration: Int = MDToast.LENGTH_SHORT,
    type: Int = MDToast.TYPE_INFO,
    bgColor: Int? = null,
    icon: Drawable? = null,
    borderRadius: Int? = null,
    elevation: Int? = null,
    typeface: Typeface? = null,
) {
    MDToast.makeText(
        this,
        message,
        duration,
        type,
        bgColor,
        icon,
        borderRadius,
        elevation,
        typeface
    ).show()
}
