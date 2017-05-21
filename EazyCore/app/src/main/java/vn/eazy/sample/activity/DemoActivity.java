package vn.eazy.sample.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.BindView;
import vn.eazy.core.base.activity.BaseMainActivity;
import vn.eazy.sample.R;
import vn.eazy.sample.fragment.MainMenuFragment;

/**
 * Created by Harry on 2/7/17.
 */

public class DemoActivity extends BaseMainActivity {
    @BindView(R.id.fragment_content)
    View view;

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
    public boolean useFragmentState() {
        return false;
    }

    @Override
    public void setUpViewsAndData() {
        fragmentHelper.replaceFragment(MainMenuFragment.Companion.newInstance(), true, R.anim.fade_in, R.anim.fade_out);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void showMenu(boolean isShow) {

    }
}
