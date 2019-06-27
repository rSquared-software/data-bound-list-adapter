package rsquared.software.recyclerview

import androidx.databinding.ViewDataBinding

/**
 * @author rSquared.software
 */
class DataBoundViewHolder<T : ViewDataBinding>(val binding: T) :
    androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)