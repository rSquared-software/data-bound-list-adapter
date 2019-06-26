package rsquared.software.example

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import rsquared.software.example.databinding.ItemAssigmentBinding
import rsquared.software.recyclerview.DataBoundListAdapter

/**
 * @author rSquared.software
 */
class AssigmentAdapter : DataBoundListAdapter<Assignment>(diffUtil) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_assigment
    }

    override fun bind(binding: ViewDataBinding, item: Assignment?, position: Int) {
        when (binding) {
            is ItemAssigmentBinding -> {
                binding.icon.setImageResource(item?.iconRes ?: R.drawable.ic_do_not_disturb_alt_black_24dp)
                binding.textContent.text = item?.text ?: "Missing"
            }
        }
    }

    companion object {
        @JvmStatic
        val diffUtil = object : DiffUtil.ItemCallback<Assignment>() {
            override fun areItemsTheSame(oldItem: Assignment, newItem: Assignment): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Assignment, newItem: Assignment): Boolean {
                return oldItem == newItem
            }
        }
    }
}