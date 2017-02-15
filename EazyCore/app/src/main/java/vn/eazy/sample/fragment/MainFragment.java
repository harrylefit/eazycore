package vn.eazy.sample.fragment;

import butterknife.OnClick;
import vn.eazy.core.base.fragment.BaseMainFragment;
import vn.eazy.sample.R;

/**
 * Created by Brian  on 15/02/2017.
 */

public class MainFragment extends BaseMainFragment {

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_fragment;
    }

    @OnClick(R.id.btn_one)
    public void clickOne(){
        getFragmentHelper().replaceFragment(DataFragment.newInstance());
    }

    @OnClick(R.id.btn_two)
    public void clickTwo(){
        getFragmentHelper().replaceFragment(PullRefreshFragment.newInstance());
    }

    @OnClick(R.id.btn_three)
    public void clickThree(){
        getFragmentHelper().replaceFragment(LoadMoreFragment.newInstance());
    }
}
