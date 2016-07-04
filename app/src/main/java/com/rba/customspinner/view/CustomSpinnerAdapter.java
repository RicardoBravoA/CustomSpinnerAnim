package com.rba.customspinner.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.rba.customspinner.control.spinner.adapter.MenuAdapter;
import com.rba.customspinner.control.spinner.adapter.SimpleTextAdapter;
import com.rba.customspinner.control.spinner.listener.OnFilterDoneListener;
import com.rba.customspinner.control.spinner.listener.OnFilterItemClickListener;
import com.rba.customspinner.control.spinner.view.SingleView;
import com.rba.customspinner.control.spinner.util.UIUtil;
import com.rba.customspinner.control.spinner.view.ItemSpinnerChecked;
import com.rba.customspinner.model.entity.ItemEntity;

import java.util.List;

/**
 * Created by Ricardo Bravo on 4/07/16.
 */

public class CustomSpinnerAdapter implements MenuAdapter {
    private final Context mContext;
    private OnFilterDoneListener onFilterDoneListener;
    private String title;
    private List<ItemEntity> itemEntityList;

    public CustomSpinnerAdapter(Context context, String title, List<ItemEntity> itemEntityList) {
        this.mContext = context;
        this.title = title;
        this.itemEntityList = itemEntityList;
        this.onFilterDoneListener = (OnFilterDoneListener) context;
    }

    @Override
    public int getMenuCount() {
        return 1;
    }

    @Override
    public String getMenuTitle(int position) {
        return title;
    }

    @Override
    public int getBottomMargin(int position) {
        return UIUtil.dp(mContext, 140);
    }

    @Override
    public View getView(int position, FrameLayout parentContainer) {

        SingleView<ItemEntity> singleView = new SingleView<ItemEntity>(mContext)
                .adapter(new SimpleTextAdapter<ItemEntity>(null, mContext) {
                    @Override
                    public String provideText(String t) {
                        return t;
                    }

                    @Override
                    protected void initCheckedTextView(ItemSpinnerChecked checkedTextView) {
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<ItemEntity>() {
                    @Override
                    public void onItemClick(ItemEntity item, int position) {
                        onFilterDoneListener.onFilterDone(position, item.getDescription());
                    }
                });

        singleView.setList(itemEntityList, -1);

        return singleView;
    }

}
