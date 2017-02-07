package vn.eazy.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import vn.eazy.core.base.activity.BaseMainActivity;

/**
 * Created by Harry on 2/7/17.
 */

public class DemoActivity extends BaseMainActivity {

    @Override
    public int onColorOfToolbar() {
        return R.color.colorPrimary;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleToolbar("Demo Page", "fonts/rosarivo_regular.otf");
        setTitleMainColor(Color.WHITE);
        showBackButton(false);
    }

    @Override
    public int onImageForLeftButtonToolbar() {
        return R.drawable.ic_arrow_back_white_24dp;
    }

    @Override
    public void setUpViewsAndData() {
        fragmentHelper.replaceFragment(DataFragment.newInstance());
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void showMenu(boolean isShow) {

    }
}
