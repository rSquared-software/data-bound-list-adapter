package rsquared.software.recyclerview.grouplist

import androidx.databinding.Observable
import androidx.recyclerview.widget.DiffUtil
import rsquared.software.recyclerview.DataBoundListAdapter

abstract class DataBoundGroupAdapter<T : GroupItem>(
    diffCallback: DiffUtil.ItemCallback<T>,
    var foldChildrenOnFold: Boolean
) :
    DataBoundListAdapter<T>(diffCallback) {

    private var submitted: List<T> = emptyList()
    private val itemVisibility: MutableSet<Long> = mutableSetOf()
    private val visibleGroups = mutableSetOf<Long>()

    private val booleanObserver = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            onExpandedChanged()
        }
    }

    override fun submitList(list: List<T>?) {
        if (list.isNullOrEmpty())
            submitted.forEach {
                if (it is GroupParent)
                    it.expanded.removeOnPropertyChangedCallback(booleanObserver)
            }

        submitted = list ?: emptyList()
        submitted.forEach {
            if (it is GroupParent) {
                it.expanded.addOnPropertyChangedCallback(booleanObserver)
            }
        }
        updateGroupMap()

        super.submitList(applyExpansions())
    }

    private fun updateGroupMap() {
        itemVisibility.clear()
        visibleGroups.clear()
        submitted.forEach {
            when (it) {
                is GroupParent ->
                    if ((it.parentId == 0L || visibleGroups.contains(it.parentId))) {
                        itemVisibility.add(it.id)
                        if (it.expanded.get())
                            visibleGroups.add(it.groupId)
                    } else if (foldChildrenOnFold)
                        it.expanded.set(false)
                else ->
                    if (it.parentId == 0L || visibleGroups.contains(it.parentId))
                        itemVisibility.add(it.id)

            }
        }
    }

    private fun applyExpansions(): List<T> =
        submitted.filter { itemVisibility.contains(it.id) }


    private fun onExpandedChanged() {
        updateGroupMap()
        super.submitList(applyExpansions())
    }

    inner class Helper(val boolean: Boolean)
}