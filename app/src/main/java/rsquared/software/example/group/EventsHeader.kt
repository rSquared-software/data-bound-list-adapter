package rsquared.software.example.group

import androidx.databinding.ObservableBoolean
import rsquared.software.recyclerview.grouplist.GroupParent

class EventsHeader(
    id: Long,
    parentId: Long = 0L,
    name: String,
    override val groupId: Long = 0L
) :
    Event(id, parentId, name), GroupParent {
    override val expanded: ObservableBoolean = ObservableBoolean()
}