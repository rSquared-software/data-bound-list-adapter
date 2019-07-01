package rsquared.software.example.group

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import rsquared.software.example.R
import rsquared.software.example.databinding.ItemEventBinding
import rsquared.software.example.databinding.ItemEventsHeaderBinding
import rsquared.software.recyclerview.DataBoundGroupAdapter
import rsquared.software.recyclerview.Expandable

class GroupAdapter : DataBoundGroupAdapter<Event>(diffUtil) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Expandable -> R.layout.item_events_header
            else -> R.layout.item_event
        }
    }

    override fun bind(binding: ViewDataBinding, item: Event?, position: Int) {
        when (binding) {
            is ItemEventBinding -> binding.item = item
            is ItemEventsHeaderBinding -> binding.header = item as? EventsHeader
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Event>() {

            override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}