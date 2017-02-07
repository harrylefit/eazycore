package vn.eazy.core.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import vn.eazy.core.base.CallbackObject;
import vn.eazy.core.base.activity.BaseActivity;
import vn.eazy.core.base.activity.BaseMainActivity;
import vn.eazy.core.helper.FragmentHelper;

/**
 * Created by Harry on 12/23/16.
 */

public abstract class BaseFragment extends Fragment {
    private BaseActivity baseActivity;
    protected View rootView;
    private Unbinder unbinder;
    private OnCallbackListener callbackListener;

    public interface OnCallbackListener {
        void onCallback(CallbackObject callbackObject);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
        preInitLayout();
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    public void preInitLayout() {
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
