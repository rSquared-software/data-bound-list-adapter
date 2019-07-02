package rsquared.software.example

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean

@BindingAdapter("iconRes")
fun ImageView.bindIconRes(res: Int?) {
    res?.also {
        setImageResource(res)
    } ?: setImageDrawable(null)
}

@BindingAdapter("toggleableBoolean")
fun View.bindToggleBoolean(target: ObservableBoolean?) {
    if (target == null) {
        setOnClickListener(null)
    } else {
        setOnClickListener {
            target.set(!target.get())
        }
    }
}

@BindingAdapter("positiveRotation", "rotateIf", requireAll = false)
fun View.bindRotation(positive: Float?, rotateIf: Boolean?) {
    rotation = if (rotateIf == true) positive ?: 180f else 0f
}