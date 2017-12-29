package com.neo.customviewpresentation;

import android.content.Context;

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
public class SizeConverter {
    public static float spToPx(Context ctx,float sp){
        return sp * ctx.getResources().getDisplayMetrics().scaledDensity;
    }

    public static float pxToDp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float dpToPx(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
