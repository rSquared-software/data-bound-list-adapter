package rsquared.software.recyclerview.grouplist

import androidx.recyclerview.widget.DiffUtil
import rsquared.software.recyclerview.DataBoundListAdapter

abstract class DataBoundGroupAdapter<T : GroupItem>(
    diffCallback: DiffUtil.ItemCallback<T>,
    open var foldChildrenOnFold: Boolean
) :
    DataBoundListAdapter<T>(diffCallback), ExpandCallback {

    protected open var submitted: List<T> = emptyList()
    protected open val itemVisibility = mutableSetOf<Long>()
    protected open val visibleGroups = mutableSetOf<Long>()

    override fun toggleGroup(target: GroupParent) {
        target.expanded = target.expanded.switch()
        onExpandedChanged()
    }

    override fun submitList(list: List<T>?) {
        val notEmptyAdapter = submitted.isNotEmpty()
        if (list.isNullOrEmpty())
            submitted.forEach {
                if (it is GroupParent) {
                    it.callback = null
                }
            }
        submitted = list ?: emptyList()
        submitted.forEach {
            if (it is GroupParent) {
                if (notEmptyAdapter)
                    it.expanded = Toggle(visibleGroups.contains(it.groupId))
                else
                    it.expanded = Toggle(false)
                it.callback = this
            }
        }
        updateGroupMap()
        super.submitList(applyExpansions())
    }

    protected open fun updateGroupMap() {
        itemVisibility.clear()
        visibleGroups.clear()
        submitted.forEach { gItem ->
            when (gItem) {
                is GroupParent ->
                    if ((gItem.parentId == 0L || visibleGroups.contains(gItem.parentId))) {
                        itemVisibility.add(gItem.id)
                        if (gItem.expanded.isOn) {
                            visibleGroups.add(gItem.groupId)
                        }
                    } else if (foldChildrenOnFold) {
                        gItem.expanded = Toggle(false)
                    }
                else ->
                    if (gItem.parentId == 0L || visibleGroups.contains(gItem.parentId))
                        itemVisibility.add(gItem.id)

            }
        }
    }

    protected open fun applyExpansions(): List<T> =
        submitted.filter { itemVisibility.contains(it.id) }

    protected open fun onExpandedChanged() {
        updateGroupMap()
        super.submitList(applyExpansions())
    }
}