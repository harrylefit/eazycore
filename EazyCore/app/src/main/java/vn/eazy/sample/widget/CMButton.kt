package vn.eazy.sample.widget

import android.content.Context
import android.util.AttributeSet
import vn.eazy.core.widget.EazyButton

/**
 * Created by Harry on 5/21/17.
 */
class CMButton : EazyButton {


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun createLightFont(): String {
        return "fonts/coco_gothic_light.ttf"
    }

    override fun createRegularFont(): String {
        return "fonts/coco_gothic.ttf"
    }

    override fun createMediumFont(): String {
        return "fonts/coco_gothic_bold.ttf"
    }

    override fun createDefaultFont(): String {
        return "fonts/coco_gothic.ttf"
    }

    override fun createItalicFont(): String {
        return "fonts/coco_gothic_italic.ttf"
    }

    override fun createThinFont(): String {
        return "fonts/fonts/coco_gothic_bold.ttf"
    }

    override fun createBoldFont(): String {
        return "fonts/coco_gothic_bold.ttf"
    }

    override fun createBlackFont(): String {
        return "fonts/rosarivo_regular.otf"
    }
}