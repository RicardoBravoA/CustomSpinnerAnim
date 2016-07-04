package com.rba.customspinner.control.spinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rba.customspinner.R;
import com.rba.customspinner.control.spinner.util.UIUtil;
import com.rba.customspinner.control.spinner.view.ItemSpinnerChecked;

import java.util.List;

/**
 * Created by Ricardo Bravo on 4/07/16.
 */

public abstract class SimpleTextAdapter<T> extends BaseBaseAdapter<T> {

    private final LayoutInflater inflater;

    public SimpleTextAdapter(List<T> list, Context context) {
        super(list, context);
        inflater = LayoutInflater.from(context);
    }

    public static class FilterItemHolder {
        ItemSpinnerChecked checkedTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FilterItemHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_spinner, parent, false);

            holder = new FilterItemHolder();
            holder.checkedTextView = (ItemSpinnerChecked) convertView;
            holder.checkedTextView.setPadding(0, UIUtil.dp(context, 15), 0, UIUtil.dp(context, 15));
            initCheckedTextView(holder.checkedTextView);

            convertView.setTag(holder);
        } else {
            holder = (FilterItemHolder) convertView.getTag();
        }

        T t = list.get(position);
        holder.checkedTextView.setText(provideText(t.toString()));

        return convertView;
    }

    public abstract String provideText(String t);

    protected void initCheckedTextView(ItemSpinnerChecked checkedTextView) {
    }


}
