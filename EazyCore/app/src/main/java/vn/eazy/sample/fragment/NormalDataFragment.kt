package vn.eazy.sample.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import net.idik.lib.slimadapter.SlimAdapter
import vn.eazy.core.base.fragment.BaseMainWithDataFragment
import vn.eazy.core.state_view.MultiStateView
import vn.eazy.sample.model.User

/**
 * Created by Harry on 4/16/17.
 */

class NormalDataFragment : BaseMainWithDataFragment(), MultiStateView.StateListener {
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.updateData(data).notifyDataSetChanged()
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

    override fun initAdapter(): SlimAdapter {
        return SlimAdapter.create().register<User>(android.R.layout.simple_list_item_1, {
            (name), injector ->
            injector.text(android.R.id.text1, name)
                    .clicked(android.R.id.text1, {
                        multiStateView.viewState = MultiStateView.VIEW_STATE_LOADING
                    })
        }).attachTo(rvData)
    }

    override fun getTypeLayoutManager(): TYPE_LAYOUT_MANAGER {
        return TYPE_LAYOUT_MANAGER.LINEAR_VERTICAL
    }

    override fun onStateListener(): MultiStateView.StateListener {
        return this
    }

    override fun onStateChanged(viewState: Int) {
        Toast.makeText(context,"State changed : " + viewState, Toast.LENGTH_SHORT).show()
    }

    override fun onStateInflated(viewState: Int, view: View) {
        Toast.makeText(context,"State inflated", Toast.LENGTH_SHORT).show()
    }

    override fun onRefresh() {
        super.onRefresh()
        adapter.data.clear();
        adapter.notifyDataSetChanged();
        swipeRefresh?.isRefreshing = false;
    }
}
