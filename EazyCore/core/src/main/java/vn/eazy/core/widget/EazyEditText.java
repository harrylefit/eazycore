package vn.eazy.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import vn.eazy.core.R;
import vn.eazy.core.helper.FontHelper;

/**
 * Created by Harry on 12/24/16.
 */

public abstract class EazyEditText extends EditText {
    private List<String> fontArrays;

    public EazyEditText(Context context) {
        super(context);
        init(context, null);
    }

    public EazyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EazyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setUpFontsArray();
        int type = 1;
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EazyTextView);
            type = typedArray.getInt(R.styleable.EazyTextView_etv_font, 1);
            typedArray.recycle();
        }
        FontHelper.setTypeFont(this, type, fontArrays);
    }

    private void setUpFontsArray() {
        if (fontArrays == null) {
            fontArrays = new ArrayList<>();
        }
        fontArrays.clear();
        fontArrays.add(createLightFont());
        fontArrays.add(createRegularFont());
        fontArrays.add(createMediumFont());
    }

    protected abstract String createLightFont();

    protected abstract String createRegularFont();

    protected abstract String createMediumFont();
}
