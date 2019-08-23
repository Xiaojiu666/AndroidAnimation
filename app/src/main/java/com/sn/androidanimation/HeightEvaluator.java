package com.sn.androidanimation;

import android.animation.TypeEvaluator;

import java.util.Random;

public class HeightEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Random random = new Random();
        int num = random.nextInt(100);
        RectangleItem startValue1 = (RectangleItem) endValue;
        float x = startValue1.getX() + num * fraction;
        return new RectangleItem(x);
    }
}
