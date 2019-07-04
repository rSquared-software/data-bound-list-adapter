package rsquared.software.example

import android.graphics.drawable.Animatable
import android.graphics.drawable.Animatable2
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import software.rsquared.logextensions.logWarning

@BindingAdapter("iconRes")
fun ImageView.bindIconRes(res: Int?) {
    res?.also {
        setImageResource(res)
    } ?: setImageDrawable(null)
}

@BindingAdapter("animateTrue", "animateFalse", "animateTrigger")
fun ImageView.bindAnimatedVector(animTrue: Drawable, animFalse: Drawable, animate: Boolean?) {
    animate ?: return
    if (animate == true)
        setImageDrawable(animTrue)
    else
        setImageDrawable(animFalse)

    when (val d = drawable) {
        is Animatable -> d.start()
        else -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && d is Animatable2)
            d.start()
        else
            logWarning("drawable is not Animatable")

    }
}