package vn.eazy.sample.viewbinder;

import android.view.View;
import android.widget.Button;

import com.tellh.nolistadapter.IListAdapter;
import com.tellh.nolistadapter.viewbinder.base.RecyclerViewBinder;
import com.tellh.nolistadapter.viewbinder.sub.ErrorRecyclerViewBinder;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.eazy.sample.R;


public class ErrorViewBinder extends ErrorRecyclerViewBinder<ErrorViewBinder.ViewHolder> {
    OnReLoadCallback callback;

    public ErrorViewBinder(OnReLoadCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void bindErrorView(IListAdapter adapter, ViewHolder holder, int position) {
        holder.btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null)
                    callback.reload();
            }
        });
    }

    @Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemLayoutId(IListAdapter adapter) {
        return R.layout.error_view;
    }

    public static class ViewHolder extends RecyclerViewBinder.ViewHolder {
        @BindView(R.id.btn_refresh)
        Button btn_refresh;

        public ViewHolder(View rootView) {
            super(rootView);
            ButterKnife.bind(this,rootView);
        }
    }

    public interface OnReLoadCallback {
        void reload();
    }

}
