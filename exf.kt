package it.log.example

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.support.v4.content.ContextCompat
import android.view.View

/**
 * Replace with your own Context
 */
fun getContext() =
    Application().applicationContext




// ExF for Context

/**
 * Check about current screen orientation: LANDSCAPE
 *
 * Example:
 *  if (context.isInLandscape)
 *   // landscape
 *      doBeautifulThing()
 *   else
 *   // portrait
 *      doOtherBeautifulThings()
 */
val Context.isInLandscape: Boolean
    get() = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE


/**
 * Similar to [isInLandscape]
 */
val Context.isInPortrait: Boolean
    get() = isInLandscape.not()


/**
 * Check if given [permission] is granted
 */
fun Context.isPermissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(
        this, permission) == PackageManager.PERMISSION_GRANTED
}


/**
 * Check if given [permission] is NOT granted
 */
fun Context.isNotPermissionGranted(permission: String): Boolean {
    return isPermissionGranted(permission).not()
}




// ExF for View

/**
 * Set visibility of [this] view to VISIBLE if [show] is true, GONE otherwise
*/
fun View.show(show: Boolean) {
    if (show) visible() else gone()
}

/**
 * Set visibility of [this] view to INVISIBLE
 */
fun View.visible() {
    visibility = View.VISIBLE
}


/**
 * Set visibility of [this] view to INVISIBLE
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}


/**
 * Set visibility of [this] view to GONE
 */
fun View.gone() {
    visibility = View.GONE
}


/**
 * Set visibility of all views of [this] collection to VISIBLE
 */
fun Collection<View>.setAllVisible() {
    forEach { it.visible() }
}


/**
 * Set visibility of all views of [this] collection to INVISIBLE
 */
fun Collection<View>.setAllInvisible() {
    forEach { it.invisible() }
}

/**
 * Set visibility of all views of [this] collection to GONE
 */
fun Collection<View>.setAllGone() {
    forEach { it.gone() }
}
