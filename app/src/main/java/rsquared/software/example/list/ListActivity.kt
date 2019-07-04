package rsquared.software.example.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*
import rsquared.software.example.R

class ListActivity : AppCompatActivity() {

    private val assignmentsAdapter = AssignmentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recycler_list.adapter = assignmentsAdapter
        assignmentsAdapter.submitList(
            listOf(
                Assignment(R.drawable.ic_assignment_black_24dp, "Get haircut"),
                Assignment(R.drawable.ic_assignment_late_black_24dp, "Overdue payment!"),
                Assignment(
                    R.drawable.ic_assignment_turned_in_black_24dp,
                    "Fall in love with Kotlin"
                )
            )
        )
    }
}