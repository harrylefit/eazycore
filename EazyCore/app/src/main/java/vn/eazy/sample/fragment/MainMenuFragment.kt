package vn.eazy.sample.fragment

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_main_menu.*
import vn.eazy.core.base.fragment.BaseMainFragment
import vn.eazy.sample.R

/**
 * Created by Harry on 4/16/17.
 */

class MainMenuFragment : BaseMainFragment(),View.OnClickListener{
    override fun getLayoutId(): Int {
        return R.layout.fragment_main_menu
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMultiStateView.setOnClickListener(this)
        btnNormalList.setOnClickListener(this)
    }

    companion object {
        fun newInstance(): MainMenuFragment {
            val args = Bundle()
            val fragment = MainMenuFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnMultiStateView -> fragmentHelper.replaceFragment(MultiStateViewFragment.newInstance())
            R.id.btnNormalList -> fragmentHelper.replaceFragment(NormalDataFragment.newInstance())
        }
    }
}
