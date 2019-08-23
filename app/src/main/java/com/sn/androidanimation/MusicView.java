package com.sn.androidanimation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MusicView extends View {

    private final Rect rect, rect1, rect2;
    private Paint mPaint, mPaint1;
    private float height = 0;
    private int circleRadius = 200;
    private RectangleItem currentPoint;
    private static  final   String TAG  ="MusicView" ;

    public MusicView(Context context) {
        this(context, null);
    }

    public MusicView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MusicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //1.初始画笔
        initPaint();
        rect = new Rect(50, 80, 130, 320);
        rect1 = new Rect(150, 80, 230, 320);
        rect2 = new Rect(250, 80, 330, 320);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        initBackground(canvas);
        if (currentPoint == null) {
            currentPoint = new RectangleItem(0);
            initItem(canvas);
            startAnmi();
        } else {
            initItem(canvas);
        }

    }

    private void initItem(Canvas canvas) {
        float x = currentPoint.getX();
        rect.top = (int)x;
        canvas.drawRect(rect, mPaint1);
        canvas.drawRect(rect1, mPaint1);
        canvas.drawRect(rect2, mPaint1);
    }

    public void startAnmi() {
        RectangleItem rectangleItem1 = new RectangleItem(height);
        RectangleItem rectangleItem2 = new RectangleItem(height);
        RectangleItem rectangleItem3 = new RectangleItem(height);
        ValueAnimator anim = ValueAnimator.ofObject(new HeightEvaluator(), rectangleItem1);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (RectangleItem) animation.getAnimatedValue();
                Log.e(TAG,currentPoint.getX()+"");
                invalidate();
            }
        });
        anim.setDuration(50000);
        anim.start();

    }

    private void initBackground(Canvas canvas) {
        canvas.drawCircle(circleRadius, circleRadius, circleRadius, mPaint);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint1 = new Paint();
        mPaint.setColor(Color.YELLOW);
        mPaint1.setColor(Color.RED);
    }
}
