package rsquared.software.example.group

import androidx.databinding.ObservableBoolean
import rsquared.software.recyclerview.Expandable

class EventsHeader(override val id: Long, groupId: Long, name: String) : Event(groupId, name), Expandable {
    override val expanded: ObservableBoolean = ObservableBoolean()
}