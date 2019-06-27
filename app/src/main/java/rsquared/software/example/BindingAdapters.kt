package rsquared.software.example

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("iconRes")
fun ImageView.bindIconRes(res: Int?) {
    res?.also {
        setImageResource(res)
    } ?: setImageDrawable(null)
}