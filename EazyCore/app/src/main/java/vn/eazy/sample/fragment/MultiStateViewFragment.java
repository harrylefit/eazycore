package vn.eazy.sample.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import vn.eazy.core.base.fragment.BaseMainFragment;
import vn.eazy.core.state_view.MultiStateView;
import vn.eazy.sample.R;

/**
 * Created by Harry on 4/16/17.
 */

public class MultiStateViewFragment extends BaseMainFragment implements MultiStateView.StateListener {
    @BindView(R.id.btnSwitch)
    Button btnSwitch;

    @BindView(R.id.multiStateView)
    MultiStateView multiStateView;

    private Handler handler;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_multistateview;
    }

    public static MultiStateViewFragment newInstance() {
        Bundle args = new Bundle();
        MultiStateViewFragment fragment = new MultiStateViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handler = new Handler();
        multiStateView.setStateListener(this);
        multiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.retry)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Hello =)))))", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @OnClick(R.id.btnSwitch)
    public void onSwitchClick() {
        multiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler = null;
    }

    @Override
    public void onStateChanged(@MultiStateView.ViewState int viewState) {
        if (viewState == MultiStateView.VIEW_STATE_LOADING) {
            Toast.makeText(getContext(), "This screen'll be switched into empty view for 2 secs", Toast.LENGTH_SHORT).show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    multiStateView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
                }
            }, 2000);
        } else if (viewState == MultiStateView.VIEW_STATE_EMPTY) {
            Toast.makeText(getContext(), "This screen'll be switched into error view for 2 secs", Toast.LENGTH_SHORT).show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    multiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
                }
            }, 2000);
        }
    }

    @Override
    public void onStateInflated(@MultiStateView.ViewState int viewState, @NonNull View view) {

    }
}