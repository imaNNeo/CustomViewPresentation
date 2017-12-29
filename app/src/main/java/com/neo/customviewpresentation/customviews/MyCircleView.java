package com.neo.customviewpresentation.customviews;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.neo.customviewpresentation.SizeConverter;

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
public class MyCircleView extends View {

    Paint circlePaint;
    RectF tempRect;



    int sweepAngle = 180;

    private float circlesWidth;
    private int circlesCount = 4;

    int leftCirclesStartDegree = -90;
    int rightCirclesStartDegree = 90;




    public MyCircleView(Context context) {
        super(context);
        init(context,null);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context,@Nullable AttributeSet attrs) {

        circlesWidth = (int) SizeConverter.dpToPx(context,18);

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStrokeWidth(circlesWidth);
        circlePaint.setColor(Color.BLUE);
        circlePaint.setStyle(Paint.Style.STROKE);

        tempRect = new RectF();


        final ValueAnimator leftAnimator = ValueAnimator.ofInt(leftCirclesStartDegree,leftCirclesStartDegree+360);
        leftAnimator.setDuration(3000);
        leftAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                leftCirclesStartDegree = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        leftAnimator.setRepeatCount(ValueAnimator.INFINITE);
        leftAnimator.setInterpolator(new LinearInterpolator());
        leftAnimator.start();




        final ValueAnimator rightAnimator = ValueAnimator.ofInt(rightCirclesStartDegree,rightCirclesStartDegree+360);
        rightAnimator.setDuration(3000);
        rightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                rightCirclesStartDegree = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        rightAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rightAnimator.setInterpolator(new LinearInterpolator());
        rightAnimator.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getDesireWidth(),getDesireHeight());
    }

    private int getDesireWidth(){
        int horizontalPadding = getPaddingLeft() + getPaddingRight();
        return (int) ((circlesCount * circlesWidth * 2) + (circlesWidth) + horizontalPadding);
    }

    private int getDesireHeight(){
        int verticalPadding = getPaddingTop() + getPaddingBottom();
        return (int) ((circlesCount * circlesWidth * 2) + (circlesWidth) + verticalPadding);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth()/2;
        int centerY = getHeight()/2;

        for(int i=1;i<=circlesCount;i++){
            float circlesSize = circlesWidth * i;

            tempRect.set(
                    centerX-circlesSize,
                    centerY-circlesSize,
                    centerX+circlesSize,
                    centerY+circlesSize);

            int startDegree;
            if(i%2==0) {
                startDegree = -leftCirclesStartDegree;
                circlePaint.setColor(Color.RED);
            }else {
                startDegree = rightCirclesStartDegree;
                circlePaint.setColor(Color.BLUE);
            }

            canvas.drawArc(tempRect,startDegree,sweepAngle,false,circlePaint);
        }


    }
}