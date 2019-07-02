package rsquared.software.example.group

import androidx.lifecycle.ViewModel

class GroupViewModel: ViewModel() {

    val eventList = listOf(
        Event(id = 10, parentId = 0, name = "Romance Dawn"),

        EventsHeader(id = 0, groupId = 1, name = "Parties"),
        Event(id = 1, parentId = 1, name = "Let's eat party"),
        Event(id = 2, parentId = 1, name = "Big Mom's tea party"),

        EventsHeader(id = 3, groupId = 2, parentId = 1, name = "Epic parties"),
        Event(id = 4, parentId = 2, name = "Enies Lobby"),
        Event(id = 11, parentId = 2, name = "Welcome to Wano"),

        EventsHeader(id = 5, groupId = 3, name = "Birthdays"),
        Event(id = 6, parentId = 3, name = "Robin's birthday"),
        Event(id = 8, parentId = 3, name = "Nami's birthday"),
        Event(id = 7, parentId = 3, name = "Franky's birthday"),
        Event(id = 9, parentId = 3, name = "Zorro's birthday")
    )

}