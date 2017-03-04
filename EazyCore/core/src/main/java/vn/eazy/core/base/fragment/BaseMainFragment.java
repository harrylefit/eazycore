package vn.eazy.core.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import vn.eazy.core.base.OnBaseActionListener;

/**
 * Created by Harry on 12/23/16.
 */

public abstract class BaseMainFragment extends BaseFragment implements OnBaseActionListener {
    @Override
    public void setTitleToolbar(String msg) {
        getBaseActivity().setTitleToolbar(msg);
    }

    @Override
    public void setTitleMainColor(int color) {
        getBaseActivity().setTitleMainColor(color);
    }

    @Override
    public void showBackButton(boolean isShow) {
        getBaseActivity().showBackButton(isShow);
    }

    @Override
    public void setTitleToolbar(String msg, String font) {
        getBaseActivity().setTitleToolbar(msg,font);
    }

    @Override
    public void showMenu(boolean isShow) {
        getBaseActivity().showMenu(isShow);
    }

    public boolean isShowMenu() {
        return true;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showMenu(isShowMenu());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
