package com.sn.androidanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sn.androidanimation.weight.BaseFragment;
import com.sn.androidanimation.weight.NoScrollViewPager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNoViewPager();
        //setAnmi();
        // setValueAnmi();

    }

    private void setNoViewPager() {
        ViewPager noScrollViewPager = (ViewPager)findViewById(R.id.NoScViewPager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        noScrollViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return new BaseFragment();
            }
            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Toast.makeText(getBaseContext(),"Activity触发",Toast.LENGTH_SHORT).show();
        Log.e("TAG","Activity触发");
        return super.onTouchEvent(event);
    }

    private void setValueAnmi() {

        //值并不是通过0-1,/时间
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
            }
        });

        valueAnimator.setDuration(1000);
        valueAnimator.start();
    }

    public void setAnmi() {
        TextView textView = (TextView) findViewById(R.id.text);
        // 创建动画作用对象：此处以Button为例
        //getTranslationY 针对 平移的一个效果 默认为0 不是坐标起点
        //https://blog.csdn.net/dmk877/article/details/51550031
        float translationY = textView.getTranslationY();
        Log.e(TAG, "translationY" + translationY);
        // ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "translationY", translationY, -100);

        //animator.addListener(new A);
        // 表示的是:
        // 动画作用对象是mButton
        // 动画作用的对象的属性是透明度alpha
        // 动画效果是:常规 - 全透明 - 常规
        animator.setDuration(5000);
        animator.start();
        float translationY1 = textView.getTranslationY();
        Log.e(TAG, "translationY" + translationY1);
    }
}
