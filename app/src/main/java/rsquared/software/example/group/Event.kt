package rsquared.software.example.group

import rsquared.software.recyclerview.grouplist.GroupItem

open class Event(
    override val id: Long,
    override val parentId: Long = 0L,
    val name: String
) : GroupItem {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Event) return false

        if (id != other.id) return false
        if (parentId != other.parentId) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + parentId.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}