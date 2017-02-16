package vn.eazy.sample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tellh.nolistadapter.adapter.RecyclerViewAdapter;

import butterknife.OnClick;
import vn.eazy.core.base.dialog.BaseAnimationDialog;
import vn.eazy.core.base.dialog.BaseDataDialog;
import vn.eazy.core.base.dialog.BaseDialog;
import vn.eazy.core.base.fragment.BaseMainFragment;
import vn.eazy.core.base.viewbinder.OnClickItemListener;
import vn.eazy.sample.R;
import vn.eazy.sample.dummy.DummyFactory;
import vn.eazy.sample.model.Data;
import vn.eazy.sample.viewbinder.DataViewBinder;

/**
 * Created by Harry on 2/16/17.
 */

public class DialogDemoFragment extends BaseMainFragment {
    private Button btnBasic;
    private Button btnAnimation;


    public static DialogDemoFragment newInstance() {
        DialogDemoFragment fragment = new DialogDemoFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_demo_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showBackButton(true);
    }

    @OnClick(R.id.btnBasic)
    public void onBasicClick() {
        BasicDialog basicDialog = new BasicDialog(getContext());
        basicDialog.show();
    }

    @OnClick(R.id.btnAnimation)
    public void onAnimationClick() {
        BasicAnimationDialog basicAnimationDialog = new BasicAnimationDialog(getContext(), 400, 400);
//        basicAnimationDialog.enableAnimation(false); //todo enable/disable animation
        basicAnimationDialog.show();
    }

    @OnClick(R.id.btnData)
    public void onDataDialogClick() {
        UserDataDialog userDataDialog = new UserDataDialog(getContext());

        //Todo create data dialog with width and height manual
//        UserDataDialog userDataDialog = new UserDataDialog(getContext()
//                , (int) (CommonHelper.getScreenWidth() * 0.5)
//                , (int) (CommonHelper.getScreenHeight() * 0.5));
        userDataDialog.show();
    }

    private class BasicDialog extends BaseDialog {
        public BasicDialog(Context context) {
            super(context);
        }

        public BasicDialog(Context context, int themeResId) {
            super(context, themeResId);
        }

        @Override
        public int getLayoutId() {
            return R.layout.basic_dialog;
        }
    }

    private class BasicAnimationDialog extends BaseAnimationDialog {

        public BasicAnimationDialog(Context context, int startAnim, int endAnim) {
            super(context, startAnim, endAnim);
        }

        public BasicAnimationDialog(Context context, int themeResId, int startAnim, int endAnim) {
            super(context, themeResId, startAnim, endAnim);
        }

        @Override
        public int getLayoutId() {
            return R.layout.animation_dialog;
        }
    }

    private class UserDataDialog extends BaseDataDialog<Data> {
        public UserDataDialog(Context context, int widthDialog, int heightDialog) {
            super(context, widthDialog, heightDialog);
        }

        public UserDataDialog(Context context) {
            super(context);
        }

        @Override
        public RecyclerViewAdapter initAdapter() {
            return RecyclerViewAdapter.builder().addItemType(new DataViewBinder(getContext())
                    .setOnClickItemListener(new OnClickItemListener<Data>() {
                        @Override
                        public void onClickItem(View view, int pos, Data model) {
                            Toast.makeText(getContext(), "Item is clicked.", Toast.LENGTH_SHORT).show();
                        }
                    }))
                    .displayList(DummyFactory.generateData())
                    .build();
        }
    }


}
