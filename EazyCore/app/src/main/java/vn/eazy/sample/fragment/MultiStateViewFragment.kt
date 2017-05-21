package vn.eazy.sample.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_multistateview.*
import vn.eazy.core.base.fragment.BaseMainFragment
import vn.eazy.core.state_view.MultiStateView
import vn.eazy.sample.R

/**
 * Created by Harry on 4/16/17.
 */

class MultiStateViewFragment : BaseMainFragment(), MultiStateView.StateListener {
    private var handler: Handler? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_multistateview
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handler = Handler()
        multiStateView?.setStateListener(this)
        multiStateView?.getView(MultiStateView.VIEW_STATE_ERROR)!!.findViewById(R.id.retry)
                .setOnClickListener { Toast.makeText(context, "Hello =)))))", Toast.LENGTH_SHORT).show() }
        btnSwitch.setOnClickListener { multiStateView?.viewState = MultiStateView.VIEW_STATE_LOADING }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler = null
    }

    override fun onStateChanged(@MultiStateView.ViewState viewState: Int) {
        if (viewState == MultiStateView.VIEW_STATE_LOADING) {
            Toast.makeText(context, "This screen'll be switched into empty view for 2 secs", Toast.LENGTH_SHORT).show()
            handler!!.postDelayed({ multiStateView!!.viewState = MultiStateView.VIEW_STATE_EMPTY }, 2000)
        } else if (viewState == MultiStateView.VIEW_STATE_EMPTY) {
            Toast.makeText(context, "This screen'll be switched into error view for 2 secs", Toast.LENGTH_SHORT).show()
            handler!!.postDelayed({ multiStateView!!.viewState = MultiStateView.VIEW_STATE_ERROR }, 2000)
        }
    }

    override fun onStateInflated(@MultiStateView.ViewState viewState: Int, view: View) {

    }

    companion object {

        fun newInstance(): MultiStateViewFragment {
            val args = Bundle()
            val fragment = MultiStateViewFragment()
            fragment.arguments = args
            return fragment
        }
    }
}