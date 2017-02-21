package vn.eazy.core.loader;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by Harry on 2/21/17.
 */

public interface LoaderUtils {
    public enum TYPE {
        SPIN, PIE, ANNULAR, BAR
    }

    void showLoading();

    void showLoaing(@NonNull String title, TYPE type);

    void showLoading(@NonNull String title);

    void showLoading(@NonNull String title,@NonNull String detail,TYPE type);

    void showLoading(@NonNull String title,@NonNull String detail);

    void showLoading(@NonNull String title,View customView);

    void hideLoading();
}
