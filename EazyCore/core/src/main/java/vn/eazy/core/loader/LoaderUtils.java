package vn.eazy.core.loader;

import android.view.View;

/**
 * Created by Harry on 2/21/17.
 */

public interface LoaderUtils {
    public enum TYPE {
        SPIN, PIE, ANNULAR, BAR
    }

    void showLoading();

    void showLoaing(String title,TYPE type);

    void showLoading(String title);

    void showLoading(String title,String detail,TYPE type);

    void showLoading(String title,String detail);

    void showLoading(String title,View customView);

    void hideLoading();
}
