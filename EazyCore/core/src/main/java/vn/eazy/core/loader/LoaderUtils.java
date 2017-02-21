package vn.eazy.core.loader;

import android.content.Context;
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

    void showLoaing(@NonNull String title, TYPE type,Context context);

    void showLoading(@NonNull String title,Context context);

    void showLoading(@NonNull String title, @NonNull String detail, TYPE type, Context context);

    void showLoading(@NonNull String title,@NonNull String detail,Context context);

    void showLoading(@NonNull String title,View customView,Context context);

    void hideLoading();
}
