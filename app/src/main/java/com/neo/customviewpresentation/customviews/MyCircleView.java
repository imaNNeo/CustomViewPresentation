package com.neo.customviewpresentation.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.neo.customviewpresentation.R;
import com.neo.customviewpresentation.SizeConverter;

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
public class MyCircleView extends View{

    Paint mPaint;
    float radius;

    public MyCircleView(Context context) {
        super(context);
        init();
    }

    float receivedStrokeSize = -1;
    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a =
                context.obtainStyledAttributes(attrs,
                        R.styleable.MyCircleView);
        //16dp is default value
        receivedStrokeSize =
                a.getDimension(R.styleable.MyCircleView_mcv_stroke_size,
                        dp2px(16));

        a.recycle();

        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        if(receivedStrokeSize>0)
            mPaint.setStrokeWidth(receivedStrokeSize);
        else
            mPaint.setStrokeWidth(dp2px(16));

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        radius = dp2px(80);
    }

    public void setStrokeSize(float strokeSize){
        mPaint.setStrokeWidth(strokeSize);
        requestLayout();
    }
    public float getStrokeSize(){
        return mPaint.getStrokeWidth();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float f = getStrokeSize();
        //Width
        int widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec);
        int width = 0;
        switch (widthMeasureMode){
            case MeasureSpec.UNSPECIFIED:
                width = getDesireWidth();
                break;
            case MeasureSpec.EXACTLY :
                width = widthMeasureSize;
                break;
            case MeasureSpec.AT_MOST :
                width = Math.min(widthMeasureSize,getDesireWidth());
                break;
        }
        //Height
        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);
        int height = 0;
        switch (heightMeasureMode){
            case MeasureSpec.UNSPECIFIED:
                height = getDesireHeight();
                break;
            case MeasureSpec.EXACTLY :
                height = heightMeasureSize;
                break;
            case MeasureSpec.AT_MOST :
                height = Math.min(heightMeasureSize,getDesireHeight());
                break;
        }
        //Radius
        if(widthMeasureMode==MeasureSpec.EXACTLY &&
                heightMeasureMode==MeasureSpec.EXACTLY) {
            int size = Math.min(widthMeasureSize,heightMeasureSize);
            radius = (size-mPaint.getStrokeWidth()) / 2;
        }else{
            //Default Value
            radius = dp2px(80);
        }
        //Tell to system measured size in px
        setMeasuredDimension(width,height);
    }

    private int getDesireHeight() {
        int vPadding = getPaddingTop() + getPaddingBottom();
        return (int) ((radius * 2) + mPaint.getStrokeWidth() + vPadding);
    }

    private int getDesireWidth() {
        int hPadding = getPaddingLeft() + getPaddingRight();
        return (int) ((radius * 2) + mPaint.getStrokeWidth() + hPadding);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        canvas.drawCircle(centerX,centerY,radius,mPaint);
    }

    private float dp2px(int dp){
        return SizeConverter.dpToPx(getContext(),dp);
    }
    private float sp2px(int sp){
        return SizeConverter.spToPx(getContext(),sp);
    }
}
