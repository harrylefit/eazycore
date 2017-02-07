package vn.eazy.core.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import vn.eazy.core.R;

/**
 * Created by Harry on 1/31/17.
 */

public abstract class BaseNavigationDrawerActivity extends BaseMainActivity {
    private DrawerLayout drawerLayout;
    private ListView lvDrawer;
    private String[] titles;

    @Override
    public int getLayoutId() {
        return R.layout.activity_drawer_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        lvDrawer = (ListView) findViewById(R.id.left_drawer);
        lvDrawer.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1
                , getTitleMenus()));
        lvDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    protected abstract String[] getTitleMenus();
}
