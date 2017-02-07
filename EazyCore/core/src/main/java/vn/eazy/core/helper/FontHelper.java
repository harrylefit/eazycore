package vn.eazy.core.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Harry on 12/24/16.
 */

public class FontHelper {
    private static final String TAG = FontHelper.class.getSimpleName();

    private static HashMap<String, Typeface> fonts = new HashMap<>();
    public static final int LIGHT_FONT = 0;
    public static final int REGULAR_FONT = 1;
    public static final int MEDIUM_FONT = 2;


    public static Typeface getFont(String font, Context context) {
        Typeface typeface = fonts.get(font);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), font);
            fonts.put(font, typeface);
        }
        return typeface;
    }

    public static void setFont(TextView textView, String font) {
        try {
            Typeface typeface = getFont(font, textView.getContext());
            textView.setTypeface(typeface);
        } catch (Exception ex) {
            Log.i(TAG, "setFont: " + ex.getMessage());
        }
    }

    public static void setTypeFont(TextView textView, int type, List<String> fontsArrays) {
        setFont(textView, fontsArrays.get(type));
    }
}
