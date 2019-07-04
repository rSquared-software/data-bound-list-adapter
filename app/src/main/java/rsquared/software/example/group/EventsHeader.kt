package rsquared.software.example.group

import androidx.databinding.ObservableBoolean
import rsquared.software.recyclerview.grouplist.ExpandCallback
import rsquared.software.recyclerview.grouplist.GroupParent
import rsquared.software.recyclerview.grouplist.Toggle

class EventsHeader(
    id: Long,
    parentId: Long = 0L,
    name: String,
    override val groupId: Long = 0L
) :
    Event(id, parentId, name), GroupParent {

    val observableExpanded = ObservableBoolean(false)

    override var expanded: Toggle = Toggle(false)
        set(value) {
            field = value
            observableExpanded.set(value.value)
        }
    override var callback: ExpandCallback? = null

    fun tryCallback() {
        callback?.toggleGroup(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EventsHeader) return false
        if (!super.equals(other)) return false

        if (groupId != other.groupId) return false
        if (observableExpanded != other.observableExpanded) return false
        if (expanded != other.expanded) return false
        if (callback != other.callback) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + groupId.hashCode()
        result = 31 * result + expanded.hashCode()
        return result
    }


}