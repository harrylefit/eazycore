package vn.eazy.sample.activity;

import vn.eazy.core.base.activity.BaseMainActivity;
import vn.eazy.sample.R;

/**
 * Created by Harry on 4/16/17.
 */

public class MainActivity extends BaseMainActivity {
    @Override
    public void showMenu(boolean isShow) {

    }

    @Override
    public void setUpViewsAndData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public int onColorOfToolbar() {
        return 0;
    }

    @Override
    public int onImageForLeftButtonToolbar() {
        return 0;
    }

    @Override
    public boolean useFragmentState() {
        return false;
    }
}
