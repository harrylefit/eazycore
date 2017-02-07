package vn.eazy.sample.viewbinder;

import android.content.Context;
import android.view.View;

import com.tellh.nolistadapter.IListAdapter;
import com.tellh.nolistadapter.viewbinder.base.RecyclerViewBinder;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.eazy.core.base.viewbinder.BaseViewBinder;
import vn.eazy.sample.R;
import vn.eazy.sample.model.Data;
import vn.eazy.sample.widget.CMTextView;

/**
 * Created by Harry on 2/7/17.
 */

public class DataViewBinder extends BaseViewBinder<Data, DataViewBinder.DataViewHolder> {

    public DataViewBinder(Context context) {
        super(context);
    }

    @Override
    public DataViewHolder provideViewHolder(View view) {
        return new DataViewHolder(view);
    }

    @Override
    public void bindView(IListAdapter iListAdapter, DataViewHolder dataViewHolder, int i, Data data) {
        super.bindView(iListAdapter, dataViewHolder, i, data);
        dataViewHolder.tvTitle.setText(data.getTitle());
    }

    @Override
    public int getItemLayoutId(IListAdapter iListAdapter) {
        return R.layout.item_data;
    }

    final class DataViewHolder extends RecyclerViewBinder.ViewHolder {
        @BindView(R.id.tvTitle)
        CMTextView tvTitle;
//
//        @BindView(R2.id.ivCover)
//        ImageView ivCover;

        DataViewHolder(View rootView) {
            super(rootView);
            ButterKnife.bind(this, rootView);
        }
    }
}
