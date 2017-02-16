package vn.eazy.sample.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.view.View;

import com.tellh.nolistadapter.DataBean;
import com.tellh.nolistadapter.adapter.FooterLoadMoreAdapterWrapper;
import com.tellh.nolistadapter.adapter.RecyclerViewAdapter;
import com.tellh.nolistadapter.viewbinder.utils.EasyEmptyRecyclerViewBinder;

import java.util.ArrayList;
import java.util.List;

import vn.eazy.core.base.fragment.BaseMainWithDataFragment;
import vn.eazy.sample.R;
import vn.eazy.sample.dummy.DummyFactory;
import vn.eazy.sample.viewbinder.DataViewBinder;
import vn.eazy.sample.viewbinder.ErrorViewBinder;

import static com.tellh.nolistadapter.adapter.FooterLoadMoreAdapterWrapper.UpdateType.REFRESH;

/**
 * Created by Brian  on 15/02/2017.
 */

public class PullRefreshFragment extends BaseMainWithDataFragment implements ErrorViewBinder.OnReLoadCallback {

    private int count = 0;

    public static PullRefreshFragment newInstance() {
        return new PullRefreshFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.addAll(DummyFactory.generateData());
    }

    @Override
    public RecyclerViewAdapter initAdapter() {
        return RecyclerViewAdapter.builder().addItemType(new DataViewBinder(getContext()))
                .setEmptyView(new EasyEmptyRecyclerViewBinder(R.layout.empty_view))
//                .setErrorView(new EasyErrorRecyclerViewBinder(R.layout.error_view)) load error without button
                .setErrorView(new ErrorViewBinder(this))
                .build();
    }

    @Override
    public TYPE_LAYOUT_MANAGER getTypeLayoutManager() {
        return TYPE_LAYOUT_MANAGER.LINEAR_VERTICAL;
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        clearAllData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(count == 2){
                    adapter.showErrorView(rvData);
                }else {
                    adapter.addAll(DummyFactory.generateData());
                    count++;
                }

                //setLoadMoreFooter tren adapter moi dung dc cai nay
//                FooterLoadMoreAdapterWrapper footerLoadMoreAdapterWrapper = (FooterLoadMoreAdapterWrapper) adapter;
//                List<DataBean> displayList = new ArrayList<>();
//                for (int i = 0; i < DummyFactory.generateData().size(); i++) {
//                    displayList.add(DummyFactory.generateData().get(i));
//                }
//                footerLoadMoreAdapterWrapper.OnGetData(displayList, REFRESH);
//                footerLoadMoreAdapterWrapper.hideErrorView(rvData);
            }
        }, 800);
        disableSwipeRefreshLayout();
    }

    @Override
    public void reload() {
        count =0 ;
        adapter.hideErrorView(rvData);
        onRefresh();
    }
}
