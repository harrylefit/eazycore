package vn.eazy.sample.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.OnClick;
import vn.eazy.core.base.activity.BaseMainActivity;
import vn.eazy.sample.R;
import vn.eazy.sample.fragment.MainStateFragment;

public class FragmentStateActivity extends BaseMainActivity {
    @Override
    public int onColorOfToolbar() {
        return R.color.colorPrimary;
    }

    @Override
    public int onImageForLeftButtonToolbar() {
        return R.drawable.ic_arrow_back_white_24dp;
    }

    @Override
    public boolean useFragmentState() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleToolbar("Demo Fragment State", "fonts/rosarivo_regular.otf");
        setTitleMainColor(Color.WHITE);
        showBackButton(true);
        fragmentStateHelper.setStacksRootFragment(MainStateFragment.newInstance("1"), MainStateFragment.newInstance("2"));
        fragmentStateHelper.showStack(0);
    }

    @OnClick(R.id.btn_tab1)
    void clickTab1() {
        fragmentStateHelper.showStack(0);
    }

    @OnClick(R.id.btn_tab2)
    void clickTab2() {
        fragmentStateHelper.showStack(1);
    }

    @Override
    public void setUpViewsAndData() {

    }

    @Override
    public void onCallBackToolbar() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (!fragmentStateHelper.isRootFragment()) {
            fragmentStateHelper.popFragment(1);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_fragment_state;
    }

    @Override
    public void showMenu(boolean isShow) {

    }
}
