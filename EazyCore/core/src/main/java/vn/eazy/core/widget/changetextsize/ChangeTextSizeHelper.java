package vn.eazy.core.widget.changetextsize;

import android.content.Context;

import vn.eazy.core.utils.PreferencesUtils;

/**
 * Created by cuong on 2/27/17.
 */

public class ChangeTextSizeHelper extends TextSizeRatioInterface {
    public static String FONT_SIZE = "font size";
    public static void setTextSizeRatio(Context context,float sizeRatio) {
        PreferencesUtils.putFloat(context, FONT_SIZE, sizeRatio);
    }



    public static float getTextSizeRatio(Context context) {
        return PreferencesUtils.getFloat(context, FONT_SIZE);
    }


}
