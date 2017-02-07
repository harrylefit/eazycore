package vn.eazy.sample.model;

import com.tellh.nolistadapter.IListAdapter;

import org.parceler.Parcel;

import vn.eazy.core.base.data.BaseModel;
import vn.eazy.sample.R;

/**
 * Created by Harry on 2/7/17.
 */
@Parcel(Parcel.Serialization.BEAN)
public class Data extends BaseModel {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data() {
    }

    public Data(String title) {
        this.title = title;
    }

    @Override
    public int getItemLayoutId(IListAdapter iListAdapter) {
        return R.layout.item_data;
    }
}
