package com.rba.customspinner.control.spinner.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo Bravo on 4/07/16.
 */

public abstract class BaseBaseAdapter<T> extends BaseAdapter {

    public List<T> list;

    protected Context context;

    public BaseBaseAdapter(List<T> list, Context context) {
        super();
        setList(list);
        this.context = context;
    }

    public void setList(List<T> list) {

        if (list == null) {
            list = new ArrayList<T>(0);
        }

        this.list = list;

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView,
                                 ViewGroup parent);

}