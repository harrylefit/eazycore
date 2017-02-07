package vn.eazy.core.base.viewbinder;

import android.content.Context;
import android.view.View;

import com.tellh.nolistadapter.IListAdapter;
import com.tellh.nolistadapter.viewbinder.base.RecyclerViewBinder;

import vn.eazy.core.R;
import vn.eazy.core.base.data.BaseModel;

/**
 * Created by Harry on 12/27/16.
 */

public abstract class BaseViewBinder<M extends BaseModel, VH extends RecyclerViewBinder.ViewHolder> extends RecyclerViewBinder<M, VH> {
    protected Context context;

    public BaseViewBinder(Context context) {
        this.context = context;
    }

    private OnClickItemListener<M> onClickItemListener;

    @Override
    public void bindView(IListAdapter iListAdapter, final VH vh, final int i, final M m) {
        if (onClickItemListener != null) {
            final View lyClick = vh.itemView.findViewById(R.id.lyClick);
            if (lyClick != null) {
                lyClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickItemListener.onClickItem(lyClick, i, m);
                    }
                });
            } else {
                vh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickItemListener.onClickItem(view, i, m);
                    }
                });
            }

        } else {
            vh.itemView.setOnClickListener(null);
        }

    }

    public BaseViewBinder setOnClickItemListener(OnClickItemListener<M> onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
        return this;
    }
}
