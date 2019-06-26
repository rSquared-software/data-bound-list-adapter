package rsquared.software.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

/**
 * @author rSquared.software
 */
abstract class PagedDataBoundListAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) : PagedListAdapter<T, DataBoundViewHolder<ViewDataBinding>>(diffCallback) {

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<ViewDataBinding> {
        return DataBoundViewHolder(createBinding(parent, viewType))
    }

    final override fun onBindViewHolder(holder: DataBoundViewHolder<ViewDataBinding>, position: Int) {
        bind(holder.binding, getItem(position), position)
        holder.binding.executePendingBindings()
    }

    open fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
    }

    abstract fun bind(binding: ViewDataBinding, item: T?, position: Int)
}