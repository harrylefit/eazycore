package vn.eazy.core.widget.changetextsize;

/**
 * Created by cuong on 2/27/17.
 */

public abstract class TextSizeRatioInterface {

    protected float getSmallSizeRatio() {
        return 0.85f;
    }

    protected float getNormalSizeRatio() {
        return 1;
    }

    protected float getBigSizeRatio() {
        return 1.2f;
    }

    protected float getLargeSizeRatio() {
        return 1.35f;
    }

}
