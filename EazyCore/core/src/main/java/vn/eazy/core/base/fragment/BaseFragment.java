package vn.eazy.core.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import vn.eazy.core.R;
import vn.eazy.core.base.CallbackObject;
import vn.eazy.core.base.activity.BaseActivity;
import vn.eazy.core.base.activity.BaseMainActivity;
import vn.eazy.core.helper.FragmentHelper;

/**
 * Created by Harry on 12/23/16.
 */

public abstract class BaseFragment extends Fragment {
    protected View rootView;
    private Unbinder unbinder;
    private OnCallbackListener callbackListener;
    private FrameLayout containerPage;
    private ProgressBar progressPage;
    private TextView tvMessagePage;
    private boolean hasStatusPageView;
    private View contentPage;

    public interface OnCallbackListener {
        void onCallback(CallbackObject callbackObject);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getStatusPageView() > 0) {
            hasStatusPageView = true;
            rootView = LayoutInflater.from(getContext()).inflate(getStatusPageView(), container, false);
            contentPage = LayoutInflater.from(getContext()).inflate(getLayoutId(), null);
            try {
                initStatusWidgets();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } else {
            rootView = LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
            hasStatusPageView = false;
        }
        preInitLayout();
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    public void showProgressPage(boolean isShow) {
        if (isShow) {
            containerPage.setVisibility(View.GONE);
            progressPage.setVisibility(View.VISIBLE);
            tvMessagePage.setVisibility(View.GONE);
        } else {
            containerPage.setVisibility(View.VISIBLE);
            progressPage.setVisibility(View.GONE);
            tvMessagePage.setVisibility(View.GONE);
        }
    }

    public void showMessagePage(String message) {
        if (!TextUtils.isEmpty(message)) {
            containerPage.setVisibility(View.GONE);
            progressPage.setVisibility(View.GONE);
            tvMessagePage.setVisibility(View.VISIBLE);
            tvMessagePage.setText(message);
        }

    }

    private void initStatusWidgets() throws IllegalAccessException {
        containerPage = (FrameLayout) rootView.findViewById(R.id.containerPage);
        progressPage = (ProgressBar) rootView.findViewById(R.id.progressPage);
        tvMessagePage = (TextView) rootView.findViewById(R.id.tvMessagePage);
        if (containerPage == null) {
            throw new IllegalAccessException("Can't find containerPage id");
        }
        if (progressPage == null) {
            throw new IllegalAccessException("Can't find progressPage id");
        }
        if (tvMessagePage == null) {
            throw new IllegalAccessException("Can't find tvMessagePage id");
        }
        containerPage.addView(contentPage);


    }

    public void preInitLayout() {
    }

    protected int getStatusPageView() {
        return 0;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView();
        bindMenu();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unBindView();
        unBindMenu();
    }

    public abstract int getLayoutId();

    public void bindView() {
    }

    public void unBindView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void bindMenu() {
    }

    public void unBindMenu() {
    }

    public BaseActivity getBaseActivity() {
        if (getActivity() instanceof BaseActivity) {
            return (BaseActivity) getActivity();
        } else {
            throw new NullPointerException("Can't cast this activity to BaseActivity");
        }
    }

    public OnCallbackListener getCallbackListener() {
        return callbackListener;
    }

    public void setCallbackListener(OnCallbackListener callbackListener) {
        this.callbackListener = callbackListener;
    }

    public FragmentHelper getFragmentHelper() {
        if (getBaseActivity() instanceof BaseMainActivity) {
            return ((BaseMainActivity) getBaseActivity()).fragmentHelper;
        } else {
            throw new NullPointerException("Can't find Fragment Helper");
        }
    }

}
