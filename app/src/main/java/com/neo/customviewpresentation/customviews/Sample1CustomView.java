package com.neo.customviewpresentation.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.neo.customviewpresentation.SizeConverter;

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
public class Sample1CustomView extends View{

    float textPaddingLeftRight;

    String drawingText = "Custom View";
    Rect drawingTextBounds = new Rect();

    Paint textPaint;
    Paint linePaint;


    public Sample1CustomView(Context context) {
        super(context);
        init(context);
    }

    public Sample1CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {

        textPaddingLeftRight = SizeConverter.dpToPx(context,8);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(SizeConverter.spToPx(context,16));
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));


        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.BLACK);
        linePaint.setStrokeWidth(SizeConverter.dpToPx(context,2));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        textPaint.getTextBounds(drawingText,0, drawingText.length(),drawingTextBounds);


        float lineSize = (getWidth() - drawingTextBounds.width() - (2*textPaddingLeftRight))/2;

        //Draw Left Line
        canvas.drawLine(0,getHeight()/2,lineSize,getHeight()/2,linePaint);
        //Draw Text
        canvas.drawText(drawingText,lineSize+textPaddingLeftRight,getHeight()/2 + (drawingTextBounds.height()/2),textPaint);
        //Draw Right Line
        canvas.drawLine(lineSize+drawingTextBounds.width()+(textPaddingLeftRight*2),getHeight()/2,getWidth(),getHeight()/2,linePaint);
    }
}
