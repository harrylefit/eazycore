package vn.eazy.sample.viewbinder;

import android.view.View;
import android.widget.ProgressBar;

import com.tellh.nolistadapter.IListAdapter;
import com.tellh.nolistadapter.adapter.FooterLoadMoreAdapterWrapper;
import com.tellh.nolistadapter.viewbinder.base.RecyclerViewBinder;
import com.tellh.nolistadapter.viewbinder.sub.FooterRecyclerViewBinder;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.eazy.sample.R;

/**
 * Created by Brian  on 15/02/2017.
 */

public class LoadMoreViewBinder extends FooterRecyclerViewBinder<LoadMoreViewBinder.ViewHolder> {

    @Override
    protected void bindFooter(IListAdapter adapter, ViewHolder holder, int position) {
        FooterLoadMoreAdapterWrapper adapterWrapper = (FooterLoadMoreAdapterWrapper) adapter;
        int size = adapter.getDisplayList().size();
        if (size == 0) {
            holder.progressBar.setVisibility(View.INVISIBLE);
//            holder.tvFooter.setText("No Data");
            return;
        }
        if (size < 10) {
//            holder.tvFooter.setText(noMoreText);
            holder.progressBar.setVisibility(View.INVISIBLE);
            return;
        }

        switch (adapterWrapper.getFooterStatus()) {
            case PULL_TO_LOAD_MORE:
                holder.progressBar.setVisibility(View.VISIBLE);
//                holder.tvFooter.setText(toLoadText);
                break;
            case LOADING:
                holder.progressBar.setVisibility(View.VISIBLE);
//                holder.tvFooter.setText(loadingText);
                break;
            case NO_MORE:
//                holder.tvFooter.setText(noMoreText);
                holder.progressBar.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    public ViewHolder provideViewHolder(View view) {
        return new LoadMoreViewBinder.ViewHolder(view);
    }

    @Override
    public int getItemLayoutId(IListAdapter iListAdapter) {
        return R.layout.footer_load_more;
    }

    public class ViewHolder extends RecyclerViewBinder.ViewHolder {

        @BindView(R.id.progress_bar)
        ProgressBar progressBar;

        public ViewHolder(View rootView) {
            super(rootView);
            ButterKnife.bind(this, rootView);
        }

    }
}
