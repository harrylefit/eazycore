package vn.eazy.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import vn.eazy.core.R;
import vn.eazy.core.helper.FontHelper;
import vn.eazy.core.utils.PreferencesUtils;
import vn.eazy.core.utils.WidgetUtils;
import vn.eazy.core.helper.ChangeTextSizeHelper;

/**
 * Created by Harry on 12/24/16.
 */

public abstract class EazyButton extends Button {
    private List<String> fontArrays;

    public EazyButton(Context context) {
        super(context);
        init(context, null);
    }

    public EazyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EazyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    private void init(Context context, AttributeSet attrs) {
        setUpFontsArray();
        int type = 1;
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EazyTextView);
            type = typedArray.getInt(R.styleable.EazyTextView_etv_font, 1);
            boolean enableChangeSize = typedArray.getBoolean(R.styleable.EazyTextView_enableChangeSize, true);
            if (enableChangeSize) {
                float fontSizeRatio = PreferencesUtils.getFloat(getContext(), ChangeTextSizeHelper.FONT_SIZE);
                setFontSize(fontSizeRatio);
            }
            typedArray.recycle();
        }
        if (fontArrays.size() > 0) {
            FontHelper.setTypeFont(this, type, fontArrays);
        }
    }

    private void setUpFontsArray() {
        if (fontArrays == null) {
            fontArrays = new ArrayList<>();
        }
        fontArrays.clear();
        if (!TextUtils.isEmpty(createLightFont())) {
            fontArrays.add(createLightFont());
        }
        if (!TextUtils.isEmpty(createRegularFont())) {
            fontArrays.add(createRegularFont());
        }
        if (!TextUtils.isEmpty(createMediumFont())) {
            fontArrays.add(createMediumFont());
        }
    }

    protected abstract String createLightFont();

    protected abstract String createRegularFont();

    protected abstract String createMediumFont();


    public void setFontSize(float ratioSize) {
        if (ratioSize <= 0 || ratioSize == 1)
            return;
        setTextSize(TypedValue.COMPLEX_UNIT_SP, WidgetUtils.pixelsToSp(getContext(), getTextSize() * ratioSize));

    }
}
