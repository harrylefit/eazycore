package vn.eazy.sample.widget;

import android.content.Context;
import android.util.AttributeSet;

import vn.eazy.core.widget.EazyTextView;

/**
 * Created by Harry on 12/24/16.
 */

public class CMTextView extends EazyTextView {

    public CMTextView(Context context) {
        super(context);
    }

    public CMTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CMTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected String createLightFont() {
        return "fonts/rosarivo_italic.otf";
    }

    @Override
    protected String createRegularFont() {
        return "fonts/rosarivo_regular.otf";
    }

    @Override
    protected String createMediumFont() {
        return "fonts/rosarivo_regular.otf";
    }
}
