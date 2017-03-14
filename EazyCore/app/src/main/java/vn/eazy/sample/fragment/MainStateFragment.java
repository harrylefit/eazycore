package vn.eazy.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import vn.eazy.core.base.activity.BaseMainActivity;
import vn.eazy.core.base.fragment.BaseMainFragment;
import vn.eazy.sample.R;
import vn.eazy.sample.activity.FragmentStateActivity;

/**
 * Created by Brian  on 15/02/2017.
 */


public class MainStateFragment extends BaseMainFragment {

    @BindView(R.id.tv_tab_number)
    TextView tvTabNumber;
    @BindView(R.id.tv_frag_number)
    TextView tvFragNumber;


    public static MainStateFragment newInstance(String tabNumber, String fragmentNumber) {
        MainStateFragment fragment = new MainStateFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tabNumber", tabNumber);
        bundle.putString("fragmentNumber", fragmentNumber);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTabNumber.setText(getArguments().getString("tabNumber"));
        tvFragNumber.setText(getArguments().getString("fragmentNumber"));
    }

    @OnClick(R.id.btn_new_frag)
    void clickNewFrag() {
        ((BaseMainActivity) getBaseActivity()).fragmentStateHelper.pushFragmentKeepOld(generateNewFragment());
    }

    @OnClick(R.id.btn_replace_frag)
    void clickReplaceFrag() {
        ((BaseMainActivity) getBaseActivity()).fragmentStateHelper.replaceFragment(generateNewFragment());
    }

    private MainStateFragment generateNewFragment() {
        switch (((BaseMainActivity) getBaseActivity()).fragmentStateHelper.getStackSelected()) {
            case 0:
                return MainStateFragment.newInstance("Tab 1", String.valueOf(
                        ((FragmentStateActivity) getBaseActivity()).tab1FragmentNumber++));
            case 1:
                return MainStateFragment.newInstance("Tab 2", String.valueOf(
                        ((FragmentStateActivity) getBaseActivity()).tab2FragmentNumber++));
        }
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_state_fragment;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
