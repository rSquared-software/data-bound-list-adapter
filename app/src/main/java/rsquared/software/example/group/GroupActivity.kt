package rsquared.software.example.group

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_group.*
import rsquared.software.example.R

class GroupActivity : AppCompatActivity() {

    private val groupAdapter = GroupAdapter()
//    private var i = 0
    private lateinit var viewModel: GroupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        viewModel = ViewModelProviders.of(this).get(GroupViewModel::class.java)

        recycler_list.adapter = groupAdapter
        groupAdapter.submitList(viewModel.eventList)
        resubmit.setOnClickListener {
            groupAdapter.submitList(viewModel.getTheOther())
//            groupAdapter.submitList(i.let {
//                if (it == 0) {
//                    viewModel.eventListCopy
//                } else {
//                    viewModel.eventList
//                }
//            })
        }
    }
}