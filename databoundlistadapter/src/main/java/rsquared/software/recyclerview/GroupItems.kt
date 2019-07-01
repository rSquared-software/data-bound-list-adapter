package rsquared.software.recyclerview

import androidx.databinding.ObservableBoolean


interface ListItem {
    val groupId: Long
}

interface Expandable : ListItem {
    val id: Long
    val expanded: ObservableBoolean
}