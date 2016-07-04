package com.rba.customspinner.control.spinner.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rba.customspinner.control.spinner.adapter.BaseBaseAdapter;
import com.rba.customspinner.control.spinner.listener.OnFilterItemClickListener;

import java.util.List;

/**
 * Created by Ricardo Bravo on 4/07/16.
 */

public class SingleView<T> extends ListView implements AdapterView.OnItemClickListener {

    private BaseBaseAdapter<T> mAdapter;
    private OnFilterItemClickListener<T> mOnItemClickListener;

    public SingleView(Context context) {
        this(context, null);
    }

    public SingleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SingleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setDivider(null);
        setDividerHeight(0);
        setSelector(new ColorDrawable(Color.TRANSPARENT));

        setOnItemClickListener(this);
    }


    public SingleView<T> adapter(BaseBaseAdapter<T> adapter) {
        this.mAdapter = adapter;
        setAdapter(adapter);
        return this;
    }

    public SingleView<T> onItemClick(OnFilterItemClickListener<T> onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        return this;
    }

    public void setList(List<T> list, int checkedPosition) {
        mAdapter.setList(list);

        if (checkedPosition != -1) {
            setItemChecked(checkedPosition, true);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        T item = mAdapter.getItem(position);
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(item, position);
        }
    }


}
