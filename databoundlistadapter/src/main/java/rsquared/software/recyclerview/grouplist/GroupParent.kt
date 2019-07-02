package rsquared.software.recyclerview.grouplist

import androidx.databinding.ObservableBoolean

interface GroupParent : GroupItem {
    val groupId: Long
    val expanded: ObservableBoolean
}