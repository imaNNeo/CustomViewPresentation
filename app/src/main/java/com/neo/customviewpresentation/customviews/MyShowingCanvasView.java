package com.neo.customviewpresentation.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.neo.customviewpresentation.R;
import com.neo.customviewpresentation.SizeConverter;

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
public class MyShowingCanvasView extends View{

    Paint axisPaint;
    float axisXYSize;

    Paint mPaint;

    RectF tempRect;
    Rect srcTmp;
    RectF dstTmp;

    Bitmap santaBmp;

    Path mPath;

    public MyShowingCanvasView(Context context) {
        super(context);
        init(context);
    }

    public MyShowingCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        axisPaint = new Paint();
        axisPaint.setStrokeWidth(SizeConverter.dpToPx(getContext(),2));
        axisPaint.setColor(Color.LTGRAY);
        axisPaint.setStyle(Paint.Style.STROKE);


        axisXYSize = SizeConverter.dpToPx(getContext(),30);


        mPaint = new Paint();

        tempRect = new RectF();
        srcTmp = new Rect();
        dstTmp = new RectF();

        santaBmp = BitmapFactory.decodeResource(getResources(), R.drawable.santa);

        mPath = new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(getWidth()>0 && getHeight()>0) {
            for (int x = 1; x <= 10; x++) {
                canvas.drawLine(x*axisXYSize, 0, x*axisXYSize, getHeight(), axisPaint);
            }

            for(int y = 1;y<=8;y++){
                canvas.drawLine(0, y*axisXYSize,getWidth(),y*axisXYSize, axisPaint);
            }
        }



        /*mPaint.setStrokeWidth(dp2px(15));
        mPaint.setColor(Color.GREEN);
        canvas.drawLine(dp2px(30),dp2px(30),
                dp2px(270),dp2px(150),mPaint);


        mPaint.setStrokeWidth(dp2px(15));
        mPaint.setColor(Color.RED);
        canvas.drawLine(dp2px(30),dp2px(150),
                dp2px(270),dp2px(30),mPaint);


        mPaint.setStrokeWidth(dp2px(10));
        mPaint.setColor(Color.MAGENTA);
        canvas.drawLine(dp2px(0),dp2px(120),
                dp2px(270),dp2px(120),mPaint);*/













        /*mPaint.setStrokeWidth(dp2px(16));
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(dp2px(150),dp2px(120),
                            dp2px(90),mPaint);


        mPaint.setStrokeWidth(dp2px(16));
        mPaint.setColor(Color.MAGENTA);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(dp2px(150),dp2px(120),
                dp2px(60),mPaint);


        mPaint.setStrokeWidth(dp2px(16));
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(dp2px(270),dp2px(210),
                dp2px(30),mPaint);*/





        /*mPaint.setAntiAlias(true);


        tempRect.set(dp2px(30),dp2px(30),
                dp2px(180),dp2px(180));

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(4));
        canvas.drawRect(tempRect,mPaint);


        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(16));
        canvas.drawArc(tempRect,
                        0f,90F,
                        false,mPaint);


        mPaint.setColor(Color.CYAN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(12));
        canvas.drawArc(tempRect,
                180f,135F,
                true,mPaint);*/






        /*Rect tempRect = new Rect();
        mPaint.setAntiAlias(true);



        String text = "Left Top";
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(sp2px(30));
        canvas.drawText(text,
                dp2px(30),dp2px(60),mPaint);



        mPaint.setStrokeWidth(dp2px(1));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.getTextBounds(text, 0,text.length(), tempRect);
        canvas.drawRect(dp2px(30),dp2px(60)-tempRect.height(),
                dp2px(30) + tempRect.width(),dp2px(60),mPaint);*/








        /*srcTmp.set(0,0,
                santaBmp.getWidth(),
                santaBmp.getHeight());
        dstTmp.set(dp2px(30),dp2px(30),
                dp2px(210),dp2px(210));
        canvas.drawBitmap(santaBmp,
                srcTmp,dstTmp,mPaint);*/





        /*mPaint.setAntiAlias(true);


        float currentX = getWidth()/2;
        float currentY = getHeight()/2;
        mPath.moveTo(currentX,currentY);

        currentX += dp2px(30);
        mPath.lineTo(currentX,currentY);

        currentY -= dp2px(30);
        mPath.lineTo(currentX,currentY);

        currentX -= dp2px(60);
        mPath.lineTo(currentX,currentY);

        currentY += dp2px(60);
        mPath.lineTo(currentX,currentY);

        currentX += dp2px(90);
        mPath.lineTo(currentX,currentY);

        currentX += dp2px(30);
        mPath.addCircle(currentX,currentY,
                dp2px(30), Path.Direction.CW);

        mPaint.setColor(Color.MAGENTA);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(3));


        //Corner Path Effect
        *//*cornerPathEffect(mPaint);*//*

        //Dash Path Effect
        *//*dashPathEffect(mPaint);*//*

        //Discrete Path Effect
        *//*discretePathEffect(mPaint);*//*

        //Compose Path Effect
        *//*composePathEffect();*//*

        canvas.drawPath(mPath,mPaint);*/


    }

    private void cornerPathEffect(Paint mPaint) {

        float radius = dp2px(12);
        CornerPathEffect cornerEffect =
                new CornerPathEffect(radius);
        mPaint.setPathEffect(cornerEffect);

    }

    private void dashPathEffect(Paint mPaint) {

        float[] intervals =
                new float[] {
                dp2px(20),dp2px(10)};
        DashPathEffect dashEffect =
                new DashPathEffect(
                        intervals,0);
        mPaint.setPathEffect(dashEffect);

    }

    private void discretePathEffect(Paint mPaint) {

        float segmentLength = dp2px(2);
        float deviation = dp2px(4);

        DiscretePathEffect discreteEffect =
                new DiscretePathEffect(
                        segmentLength
                        ,deviation);
        mPaint.setPathEffect(discreteEffect);

    }

    private void composePathEffect() {

        float[] intervals =
                new float[] {
                        dp2px(20),dp2px(10)};
        DashPathEffect dashEffect =
                new DashPathEffect(
                        intervals,0);


        float radius = dp2px(12);
        CornerPathEffect cornerPathEffect =
                new CornerPathEffect(radius);


        ComposePathEffect composeEffect =
                new ComposePathEffect(
                        dashEffect,
                        cornerPathEffect);
        mPaint.setPathEffect(composeEffect);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int)dp2px(300),(int)dp2px(240));
    }

    private float dp2px(int dp){
        return SizeConverter.dpToPx(getContext(),dp);
    }
    private float sp2px(int sp){
        return SizeConverter.spToPx(getContext(),sp);
    }
}
