package vn.eazy.sample.fragment

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_normal_data.*
import net.idik.lib.slimadapter.SlimAdapter
import vn.eazy.core.base.fragment.BaseMainFragment
import vn.eazy.sample.R
import vn.eazy.sample.model.User

/**
 * Created by Harry on 4/16/17.
 */

class NormalDataFragment : BaseMainFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_normal_data
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.updateData(data).notifyDataSetChanged()
    }

    private val adapter by lazy {
        SlimAdapter.create().register<User>(android.R.layout.simple_list_item_1, {
            data, injector ->
            injector.text(android.R.id.text1, data.name)
        }).attachTo(rvData)
    }

    companion object {
        fun newInstance(): NormalDataFragment {
            return NormalDataFragment()
        }

        private val data = ArrayList<User>()

        init {
            data.add(User("Harry", "HCM"))
            data.add(User("Louis", "Singapore"))
            data.add(User("Julian", "Singapore"))
            data.add(User("Iris", "Thailand"))
        }
    }
}
