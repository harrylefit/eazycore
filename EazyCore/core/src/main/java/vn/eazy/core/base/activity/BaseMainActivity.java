package vn.eazy.core.base.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import vn.eazy.core.R;
import vn.eazy.core.helper.FragmentHelper;
import vn.eazy.core.toolbar.OnCallBackToolbarAction;
import vn.eazy.core.toolbar.ToolbarHelper;

/**
 * Created by QuangTo on 12/24/16.
 */

public abstract class BaseMainActivity extends BaseActivity implements OnCallBackToolbarAction {
    private final String NULL_TOOLBAR_EX = "Can't find toolbar of this activity. Please checking it. Note: With raw id : R.id.toolbar";
    public ToolbarHelper toolbarHelper;
    protected Toolbar toolbar;
    public FragmentHelper fragmentHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        fragmentHelper = new FragmentHelper(getSupportFragmentManager(), R.id.fragment_content);
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();
    }

    @Override
    public void onCallBackToolbar() {
        fragmentHelper.popBackStack();
    }

    @Override
    public void setTitleToolbar(String msg) {
        toolbarHelper.setTitle(msg);
    }

    @Override
    public void setTitleToolbar(@NonNull String msg,@NonNull String font) {
        toolbarHelper.setTitle(msg,font);
    }

    @Override
    public void showBackButton(boolean isShow) {
        toolbarHelper.showBackButton(isShow, this);
    }

    @Override
    public void setTitleMainColor(int color) {
        toolbarHelper.setTitleMainColor(color);
    }

    private void setupToolbar() {
        if (toolbar == null) {
            throw new NullPointerException(NULL_TOOLBAR_EX);
        } else {
            setSupportActionBar(toolbar);
            toolbar.setBackgroundResource(onColorOfToolbar());
            try {
                toolbarHelper = new ToolbarHelper(toolbar);
                toolbarHelper.setImageForLeftButton(onImageForLeftButtonToolbar());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract int onColorOfToolbar();

    public abstract int onImageForLeftButtonToolbar();
}
