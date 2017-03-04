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

/**
 * Created by Brian  on 15/02/2017.
 */


public class MainStateFragment extends BaseMainFragment {

    @BindView(R.id.tv_frag_number)
    TextView tvFragNumber;

    public static MainStateFragment newInstance(String fragmentNumber) {
        MainStateFragment fragment = new MainStateFragment();
        Bundle bundle = new Bundle();
        bundle.putString("fragmentNumber", fragmentNumber);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments().getString("fragmentNumber") != null) {
            tvFragNumber.setVisibility(View.VISIBLE);
            tvFragNumber.setText("Tab " + getArguments().getString("fragmentNumber"));
        } else {
            tvFragNumber.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.btn_new_frag)
    void clickNewFrag() {
        ((BaseMainActivity) getBaseActivity()).fragmentStateHelper.pushFragment(MainStateFragment.newInstance(null));
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
