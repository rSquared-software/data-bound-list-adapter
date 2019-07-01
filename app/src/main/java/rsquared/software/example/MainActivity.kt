package rsquared.software.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rsquared.software.example.group.Event
import rsquared.software.example.group.EventsHeader
import rsquared.software.example.group.GroupAdapter

class MainActivity : AppCompatActivity() {
    private val assignmentsAdapter = AssignmentAdapter()
    private val groupAdapter = GroupAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recycler_list.adapter = assignmentsAdapter
//
//        assignmentsAdapter.submitList(
//            listOf(
//                Assignment(R.drawable.ic_assignment_black_24dp, "Get haircut"),
//                Assignment(R.drawable.ic_assignment_late_black_24dp, "Overdue payment!"),
//                Assignment(
//                    R.drawable.ic_assignment_turned_in_black_24dp,
//                    "Fall in love with Kotlin"
//                )
//            )
//        )

        recycler_list.adapter = groupAdapter
        groupAdapter.submitList(
            listOf(
                EventsHeader(1, 0, "Parties"),
                Event(1, "Let's eat party"),
                Event(1, "Welcome to Wano Island"),
                EventsHeader(11, 1, "Birthdays"),
                Event(11, "Welcome to Wano Island"),
                EventsHeader(2, 0, "Birthdays"),
                Event(2, "Robin's birthday"),
                Event(2, "Franky's birthday"),
                Event(2, "Nami's birthday"),
                Event(2, "Zorro's birthday")
            )
        )
    }
}
