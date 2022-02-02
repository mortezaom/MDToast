package dev.mortezaom.mdtoast

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.marginLeft

/**
 * Material Design Toast class
 *
 * Created by Morteza Omar on 02/01/2022.
 */
class MDToast
/**
 * Construct an empty Toast object.  You must call [.setView] before you
 * can call [.show].
 *
 * @param context The context to use.  Usually your [Application]
 * or [Activity] object.
 */(private val mContext: Context) : Toast(mContext) {
    private var mView: CardView? = null
    /**
     * @return  the type of MDToast which is actual used.
     */
    /**
     * Set the type of the MDToast.
     * @param type  the type to set.
     */
    var type = 0

    override fun setText(@StringRes resId: Int) {
        setText(mContext.getString(resId))
    }

    override fun setText(s: CharSequence) {
        if (mView == null) {
            throw RuntimeException("This Toast was not created with Toast.makeText()")
        }
        val tv = mView!!.findViewById<View>(R.id.text) as TextView
        tv.text = s
    }

    /**
     * Set the icon resource id to display in the MD toast.
     * @param iconId    the resource id.
     */
    fun setIcon(@DrawableRes iconId: Int) {
        setIcon(ContextCompat.getDrawable(mContext, iconId))
    }

    /**
     * Set the icon to display in the MD toast.
     * @param icon  the drawable to set as icon.
     */
    fun setIcon(icon: Drawable?) {
        if (mView == null) {
            throw RuntimeException("This Toast was not created with Toast.makeText()")
        }
        val iv = mView!!.findViewById<View>(R.id.icon) as ImageView
        if (icon == null) {
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            params.setMargins(8.dp, 0, 0, 0)
            iv.layoutParams = params
        }
        iv.setImageDrawable(icon)
    }

    /**
     * Set the color of background in the MD toast.
     * @param color  the Int to set as background color.
     */
    fun setBackgroundColor(color: Int) {
        if (mView == null) {
            throw RuntimeException("This Toast was not created with Toast.makeText()")
        }
        mView!!.setCardBackgroundColor(color)
    }

    /**
     * Set the radius of corners in the MD toast (size is in DP).
     * @param radius  the Int to set as card corner radius.
     */
    fun setBorderRadius(radius: Int) {
        if (mView == null) {
            throw RuntimeException("This Toast was not created with Toast.makeText()")
        }
        mView!!.radius = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            if (radius > 0) radius.toFloat() else 30F,
            mContext.resources.displayMetrics
        )
    }

    /**
     * Set the radius of corners in the MD toast between 1-32 (size is in DP).
     * @param elevation  the Int to set as card elevation (shadow).
     */
    fun setCardElevation(elevation: Int) {
        if (mView == null) {
            throw RuntimeException("This Toast was not created with Toast.makeText()")
        }
        mView!!.cardElevation = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            if (elevation in 1..32) elevation.toFloat() else 0F,
            mContext.resources.displayMetrics
        )
    }


    /**
     * Set the typeface of message in the MD toast.
     * @param tf  the Int to set as message typeface.
     */
    fun setTextTypeface(tf: Typeface) {
        if (mView == null) {
            throw RuntimeException("This Toast was not created with Toast.makeText()")
        }
        val tv = mView!!.findViewById<View>(R.id.text) as TextView
        tv.typeface = tf
    }

    companion object {
        const val TYPE_INFO = 0
        const val TYPE_SUCCESS = 1
        const val TYPE_WARNING = 2
        const val TYPE_ERROR = 3
        var LENGTH_LONG = Toast.LENGTH_LONG
        var LENGTH_SHORT = Toast.LENGTH_SHORT

        @JvmOverloads
        fun makeText(
            context: Context,
            message: String?,
            duration: Int = LENGTH_SHORT,
            type: Int = TYPE_INFO,
        ): MDToast {
            val mdToast = MDToast(context)
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: CardView = inflater.inflate(R.layout.custom_toast_container, null) as CardView
            val icon = view.findViewById<View>(R.id.icon) as ImageView
            val text = view.findViewById<View>(R.id.text) as TextView
            when (type) {
                TYPE_SUCCESS -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_circle_24
                        )
                    )
                    view.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorSuccess
                        )
                    )
                }
                TYPE_WARNING -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_24
                        )
                    )
                    view.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorWarning
                        )
                    )
                }
                TYPE_ERROR -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_24
                        )
                    )
                    view.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorError
                        )
                    )
                }
                else -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_24
                        )
                    )
                    view.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorInfo
                        )
                    )
                }
            }
            text.text = message
            mdToast.duration = duration
            mdToast.view = view
            mdToast.mView = view
            mdToast.type = type
            return mdToast
        }

        fun makeText(
            context: Context,
            message: String?,
            duration: Int = LENGTH_SHORT,
            type: Int = TYPE_INFO,
            bgColor: Int?,
            tIcon: Drawable?,
            borderRadius: Int?,
            elevation: Int?,
            typeface: Typeface?
        ): MDToast {
            val mdToast = MDToast(context)
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: CardView = inflater.inflate(R.layout.custom_toast_container, null) as CardView
            val icon = view.findViewById<View>(R.id.icon) as ImageView
            val text = view.findViewById<View>(R.id.text) as TextView
            when (type) {
                TYPE_SUCCESS -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_circle_24
                        )
                    )
                    view.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorSuccess
                        )
                    )
                }
                TYPE_WARNING -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_24
                        )
                    )
                    view.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorWarning
                        )
                    )
                }
                TYPE_ERROR -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_24
                        )
                    )
                    view.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorError
                        )
                    )
                }
                else -> {
                    icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_24
                        )
                    )
                    view.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorInfo
                        )
                    )
                }
            }
            text.text = message
            mdToast.duration = duration
            mdToast.view = view
            mdToast.mView = view
            mdToast.type = type
            bgColor?.apply { mdToast.setBackgroundColor(this) }
            tIcon.apply { mdToast.setIcon(this) }
            borderRadius?.apply { mdToast.setBorderRadius(this) }
            elevation?.apply { mdToast.setCardElevation(this) }
            typeface?.apply { mdToast.setTextTypeface(this) }
            return mdToast
        }
    }
}

private val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()