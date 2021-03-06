package vn.eazy.core.toolbar;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
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

    protected Toolbar toolbar;
    protected ImageView leftBtn;
    protected TextView tvTitle;
    protected TextView rightBtn;
    protected Context context;

    public ToolbarHelper(Toolbar toolbar) throws IllegalAccessException {
        this.toolbar = toolbar;
        context = toolbar.getContext();
        leftBtn = (ImageView) toolbar.findViewById(R.id.left_button);
        rightBtn = (TextView) toolbar.findViewById(R.id.right_button);
        if (rightBtn == null) {
            throw new IllegalAccessException("Can't find this right button");
        }
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
    public void showRightToolbar(boolean isShow) {
        rightBtn.setVisibility(isShow ? View.VISIBLE : View.GONE);
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

    @Override
    public void setRightToolbarButton(String text, View.OnClickListener onClickListener) {

        rightBtn.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (rightBtn == null)
            return;
        if (TextUtils.isEmpty(text)) {
            rightBtn.setVisibility(View.GONE);
        } else {
            rightBtn.setText(text);
            rightBtn.setVisibility(View.VISIBLE);
            setupOnClickListener(onClickListener);
        }
    }

    private void setupOnClickListener(final View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            rightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(v);
                }
            });
        }
    }

    @Override
    public void setRightToolbarButton(int iconRes, View.OnClickListener onClickListener) {
        rightBtn.setText("");
        if (rightBtn == null)
            return;
        if (iconRes <= 0) {
            rightBtn.setVisibility(View.GONE);
        } else {
            rightBtn.setVisibility(View.VISIBLE);
            Drawable drawable = ContextCompat.getDrawable(context, iconRes);
            rightBtn.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
            setupOnClickListener(onClickListener);
        }
    }
}
