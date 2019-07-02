package rsquared.software.example.group

import rsquared.software.recyclerview.grouplist.GroupItem

open class Event(
    override val id: Long,
    override val parentId: Long = 0L,
    val name: String
) : GroupItem