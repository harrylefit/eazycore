package vn.eazy.sample.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.tellh.nolistadapter.adapter.RecyclerViewAdapter;

import vn.eazy.core.base.fragment.BaseMainWithDataFragment;
import vn.eazy.core.base.viewbinder.OnClickItemListener;
import vn.eazy.sample.dialog.BaseDialog;
import vn.eazy.sample.dummy.DummyFactory;
import vn.eazy.sample.model.Data;
import vn.eazy.sample.viewbinder.DataViewBinder;

/**
 * Created by Harry on 2/7/17.
 */

public class DataFragment extends BaseMainWithDataFragment {
    public static DataFragment newInstance() {
        DataFragment fragment = new DataFragment();
        return fragment;
    }

    @Override
    public RecyclerViewAdapter initAdapter() {
        return RecyclerViewAdapter.builder().addItemType(new DataViewBinder(getContext())
                .setOnClickItemListener(new OnClickItemListener<Data>() {
                    @Override
                    public void onClickItem(View view, int pos, Data model) {
                        Toast.makeText(getContext(), "Click item", Toast.LENGTH_SHORT).show();
                        BaseDialog.Builder customBuilder = new
                                BaseDialog.Builder(getContext());
                        customBuilder.setLayoutCustom(R.layout.custom_dialog).setIcon(R.drawable.ic_home_white_24dp).setTitle("Custom Dialog Title")
                                .setMessage("Custom dialog message")
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                .setPositiveButton("Confirm",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                        customBuilder.create().show();
                    }
                })).build();
    }

    @Override
    public TYPE_LAYOUT_MANAGER getTypeLayoutManager() {
        return TYPE_LAYOUT_MANAGER.LINEAR_VERTICAL;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.addAll(DummyFactory.generateData());
    }
}
