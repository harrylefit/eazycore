package vn.eazy.sample.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.OnClick;
import vn.eazy.core.base.activity.BaseMainActivity;
import vn.eazy.sample.R;
import vn.eazy.sample.fragment.DataFragment;
import vn.eazy.sample.fragment.MainStateFragment;

public class FragmentStateActivity extends BaseMainActivity {
    public int tab1FragmentNumber = 0;
    public int tab2FragmentNumber = 0;

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

        fragmentStateHelper.setStacksRootFragment(
                MainStateFragment.newInstance("Tab 1", String.valueOf(tab1FragmentNumber++)),
                MainStateFragment.newInstance("Tab 2", String.valueOf(tab2FragmentNumber++)));
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

    @OnClick(R.id.btn_clear_stack_1)
    void clickClearStack1() {
        fragmentStateHelper.clearStack(0);
        tab1FragmentNumber = 1;
    }

    @OnClick(R.id.btn_clear_stack_2)
    void clickClearStack2() {
        fragmentStateHelper.clearStack(1);
        tab2FragmentNumber = 1;
    }

    @OnClick(R.id.btn_change_root_stack_1)
    void clickChangeRootStack1() {
        fragmentStateHelper.changeRootFragment(DataFragment.newInstance(), 0);
    }

    @OnClick(R.id.btn_change_root_stack_2)
    void clickChangeRootStack2() {
        fragmentStateHelper.changeRootFragment(DataFragment.newInstance(), 1);
    }

    @OnClick(R.id.btn_clear_all_stack)
    void clickClearAllStack() {
        fragmentStateHelper.clearAllStacks();
        tab1FragmentNumber = 1;
        tab2FragmentNumber = 1;
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
            super.onCallBackToolbar();
            switch (fragmentStateHelper.getStackSelected()) {
                case 0:
                    tab1FragmentNumber--;
                    break;
                case 1:
                    tab2FragmentNumber--;
                    break;
            }
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
