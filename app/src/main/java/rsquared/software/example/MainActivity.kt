package rsquared.software.example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rsquared.software.example.group.GroupActivity
import rsquared.software.example.list.ListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_button.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }

        group_button.setOnClickListener {
            startActivity(Intent(this, GroupActivity::class.java))
        }
    }

}
