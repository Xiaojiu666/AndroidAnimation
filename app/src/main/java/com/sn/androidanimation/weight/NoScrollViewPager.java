package com.sn.androidanimation.weight;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPager extends ViewPager {

    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 设置其是否能滑动换页
     * @param isCanScroll false 不能换页， true 可以滑动换页
     */

    private boolean isCanScroll = false;

    public void setScanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return isCanScroll && super.onInterceptTouchEvent(ev);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        return super.onTouchEvent(ev);
//       // return isCanScroll;
//    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        return isCanScroll;
//    }

}
