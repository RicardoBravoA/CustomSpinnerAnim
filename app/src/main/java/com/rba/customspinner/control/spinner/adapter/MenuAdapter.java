package com.rba.customspinner.control.spinner.adapter;

import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Ricardo Bravo on 4/07/16.
 */

public interface MenuAdapter {

    int getMenuCount();

    String getMenuTitle(int position);

    int getBottomMargin(int position);

    View getView(int position, FrameLayout parentContainer);
}