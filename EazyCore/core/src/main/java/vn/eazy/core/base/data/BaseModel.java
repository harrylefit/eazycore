package vn.eazy.core.base.data;

import com.tellh.nolistadapter.DataBean;
import com.tellh.nolistadapter.IListAdapter;

/**
 * Created by Harry on 12/25/16.
 */
public abstract class BaseModel extends DataBean {
    @Override
    public int getItemLayoutId(IListAdapter iListAdapter) {
        return 0;
    }
}
