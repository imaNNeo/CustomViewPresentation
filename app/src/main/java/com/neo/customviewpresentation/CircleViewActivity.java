package com.neo.customviewpresentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import com.neo.customviewpresentation.customviews.MyCircleView;

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
public class CircleViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        SeekBar sbStrokeSize = findViewById(R.id.sb_strokeSize);
        final MyCircleView myCircleView = findViewById(R.id.my_circle_view);

        sbStrokeSize.setMax(150);
        sbStrokeSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float sizeInDp = SizeConverter.dpToPx(CircleViewActivity.this,progress+1);
                myCircleView.setStrokeSize(sizeInDp);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}