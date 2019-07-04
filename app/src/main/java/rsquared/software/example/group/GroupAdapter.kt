package rsquared.software.example.group

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import rsquared.software.example.R
import rsquared.software.example.databinding.ItemEventBinding
import rsquared.software.example.databinding.ItemEventsHeaderBinding
import rsquared.software.recyclerview.grouplist.DataBoundGroupAdapter
import software.rsquared.logextensions.logInfo
import software.rsquared.logextensions.logVerbose

class GroupAdapter : DataBoundGroupAdapter<Event>(diffUtil, false) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is EventsHeader -> R.layout.item_events_header
            else -> R.layout.item_event
        }
    }

    override fun bind(binding: ViewDataBinding, item: Event?, position: Int) {
        when (binding) {
            is ItemEventBinding -> binding.item = item
            is ItemEventsHeaderBinding -> {
                binding.header = item as? EventsHeader
                binding.nah.visibility =
                    if (binding.header?.parentId == 0L) View.GONE else View.INVISIBLE
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Event>() {

            override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
                logVerbose("areItemsTheSame ${oldItem.id == newItem.id} <- [$oldItem, $newItem]")
                return /*oldItem === newItem &&*/ oldItem.id == newItem.id
            }


            override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
//                if(oldItem is EventsHeader && newItem is EventsHeader){
//                    return oldItem == newItem && oldItem.expanded === newItem.expanded
//                }
                logInfo("areContentsTheSame ${oldItem == newItem} <- [$oldItem, $newItem]")
                return oldItem == newItem
            }
        }
    }
}