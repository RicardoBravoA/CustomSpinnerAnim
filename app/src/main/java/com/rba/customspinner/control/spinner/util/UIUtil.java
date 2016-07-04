package com.rba.customspinner.control.spinner.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Ricardo Bravo on 4/07/16.
 */

public class UIUtil {

    public static int dp(Context context, int dp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, context.getResources().getDisplayMetrics()) + 0.5F);
    }

}
