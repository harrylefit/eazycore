package vn.eazy.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import vn.eazy.core.base.fragment.BaseMainFragment;
import vn.eazy.sample.R;

/**
 * Created by Harry on 4/16/17.
 */

public class MainMenuFragment extends BaseMainFragment {
    @BindView(R.id.btnMultiStateView)
    AppCompatButton btnMultiStateView;

    @BindView(R.id.btnNormalList)
    AppCompatButton btnNormalList;

    public static MainMenuFragment newInstance() {
        Bundle args = new Bundle();

        MainMenuFragment fragment = new MainMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_menu;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.btnMultiStateView)
    public void onMultiStateViewClick() {
        getFragmentHelper().replaceFragment(MultiStateViewFragment.newInstance());
    }

    @OnClick(R.id.btnNormalList)
    public void onNormalListClick() {
        getFragmentHelper().replaceFragment(NormalDataFragment.Companion.newInstance());
    }

}
