package vn.eazy.core.toolbar;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.eazy.core.R;

/**
 * Created by QuangTo on 12/24/16.
 */

public class ToolbarHelper implements OnToolbarAction {

    private Toolbar toolbar;
    private ImageView leftBtn;
    private TextView tvTitle;

    public ToolbarHelper(Toolbar toolbar) throws IllegalAccessException {
        this.toolbar = toolbar;
        leftBtn = (ImageView) toolbar.findViewById(R.id.left_button);
        if (leftBtn == null) {
            throw new IllegalAccessException("Can't find this Left button");
        }
        tvTitle = (TextView) toolbar.findViewById(R.id.tvTitleToolbar);
        if (tvTitle == null) {
            throw new IllegalAccessException("Can't find this Title TextView");
        }
    }

    @Override
    public void setTitle(@NonNull String title) {
        if (toolbar != null)
            setTitle(title, "");
    }

    @Override
    public void setTitle(@NonNull String title, @NonNull String font) {
        tvTitle.setText(title);
        if (!TextUtils.isEmpty(font)) {
            tvTitle.setTypeface(Typeface.createFromAsset(tvTitle.getContext().getAssets(), font));
        }
    }

    @Override
    public void setTitleMainColor(int color) {
        if (toolbar != null)
            tvTitle.setTextColor(color);
    }

    @Override
    public void showToolbar(boolean isShow) {
        if (toolbar != null)
            if (isShow) {
                toolbar.setVisibility(View.VISIBLE);
            } else {
                toolbar.setVisibility(View.GONE);
            }
    }

    @Override
    public void showBackButton(boolean isShow) {
        showBackButton(isShow, null);
    }

    @Override
    public void showBackButton(boolean isShow, final OnCallBackToolbarAction onCallBackToolbarAction) {
        if (toolbar != null)
            if (isShow) {
                leftBtn.setVisibility(View.VISIBLE);
            } else {
                leftBtn.setVisibility(View.GONE);
            }
        if (onCallBackToolbarAction != null) {
            leftBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCallBackToolbarAction.onCallBackToolbar();
                }
            });
        } else {
            leftBtn.setOnClickListener(null);
        }
    }

    @Override
    public void setImageForLeftButton(int drawable) {
        leftBtn.setImageResource(drawable);
    }
}
