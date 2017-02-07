package vn.eazy.core.base;

/**
 * Created by Harry on 12/23/16.
 */

public interface OnBaseActionListener {
    void setTitleToolbar(String msg);

    void setTitleToolbar(String msg,String font);

    void setTitleMainColor(int color);

    void showBackButton(boolean isShow);

    void showMenu(boolean isShow);
}
