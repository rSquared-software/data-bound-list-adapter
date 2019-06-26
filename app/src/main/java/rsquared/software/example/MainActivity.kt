package rsquared.software.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val assignmentsAdapter = AssigmentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_list.adapter = assignmentsAdapter

        assignmentsAdapter.submitList(
            listOf(
                Assignment(R.drawable.ic_assignment_black_24dp, "Implement new library"),
                null,
                Assignment(R.drawable.ic_assignment_late_black_24dp, "Overdue payment!"),
                Assignment(R.drawable.ic_assignment_turned_in_black_24dp, "Fall in love with Kotlin")
            )
        )
    }
}
