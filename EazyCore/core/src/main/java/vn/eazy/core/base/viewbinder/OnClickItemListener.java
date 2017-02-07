package vn.eazy.core.base.viewbinder;

import android.view.View;

import vn.eazy.core.base.data.BaseModel;

/**
 * Created by Harry on 12/26/16.
 */

public interface OnClickItemListener<M extends BaseModel> {
    void onClickItem(View view, int pos, M model);
}
