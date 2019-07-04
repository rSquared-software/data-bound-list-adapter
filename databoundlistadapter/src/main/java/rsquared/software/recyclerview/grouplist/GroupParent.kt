package rsquared.software.recyclerview.grouplist

interface GroupParent : GroupItem {
    val groupId: Long
    var expanded: Toggle
    var callback: ExpandCallback?
}

