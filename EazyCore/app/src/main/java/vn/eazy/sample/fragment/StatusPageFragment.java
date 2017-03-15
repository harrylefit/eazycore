package vn.eazy.sample.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;

import vn.eazy.core.base.fragment.BaseMainFragment;
import vn.eazy.sample.R;

/**
 * Created by cuong on 3/9/17.
 */

public class StatusPageFragment extends BaseMainFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_status_page;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showProgressPage(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // showProgressPage(false);
                showMessagePage("Error some thing!");
            }
        },1000);
    }

    @Override
    protected int getStatusPageView() {
        return R.layout.layout_status_page;
    }
}
