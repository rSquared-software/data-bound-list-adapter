package rsquared.software.recyclerview

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class DataBoundGroupAdapter<T : ListItem>(diffCallback: DiffUtil.ItemCallback<T>) :
    DataBoundListAdapter<T>(diffCallback) {

    private var submitted: List<T> = emptyList()
    private val groups: MutableMap<Long, Boolean> = mutableMapOf()

    private val booleanObserver = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            onExpandedChanged()
        }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        Log.e("GroupAdapter", "I Am Detach From Recycler View")
    }

    override fun onViewDetachedFromWindow(holder: DataBoundViewHolder<ViewDataBinding>) {
        super.onViewDetachedFromWindow(holder)
        Log.e("GroupAdapter", "I Am Detach From Window")
    }

    override fun submitList(list: List<T>?) {
        if (list.isNullOrEmpty())
            submitted.forEach {
                if (it is Expandable)
                    it.expanded.removeOnPropertyChangedCallback(booleanObserver)
            }

        submitted = list ?: emptyList()
        submitted.forEach {
            if (it is Expandable) {
                it.expanded.set(groups[it.id] ?: false)//set previous if existing
                it.expanded.addOnPropertyChangedCallback(booleanObserver)
            }
        }
        updateGroupMap()

        super.submitList(applyExpansions())
    }

    private fun updateGroupMap() {
        groups.clear()
        submitted.forEach {
            when (it) {
                is Expandable ->
                    groups[it.id] = it.expanded.get()
            }
        }
    }

    private fun applyExpansions(): List<T> =
        submitted.filter { groups[it.groupId] ?: true }


    private fun onExpandedChanged() {
        updateGroupMap()
        super.submitList(applyExpansions())
    }
}