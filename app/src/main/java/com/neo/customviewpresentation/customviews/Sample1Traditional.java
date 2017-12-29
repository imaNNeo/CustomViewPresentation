package com.neo.customviewpresentation.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.neo.customviewpresentation.R;

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
public class Sample1Traditional extends RelativeLayout{
    public Sample1Traditional(Context context) {
        super(context);
        init(context);
    }

    public Sample1Traditional(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.sample1_traditional,this);
    }
}
