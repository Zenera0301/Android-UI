package com.dj.ui.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.dj.ui.R;

public class GradientLayout extends View {

    private Paint mPaint;
    private Shader mShader;
    Bitmap mMBitmap;

    public GradientLayout(Context context) {
        this(context, null);
    }

    public GradientLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GradientLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true); // 抗锯齿
        mPaint.setStyle(Paint.Style.FILL); // 描边效果
        mMBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.beauty);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 线性渲染

//        // 定义渲染器
//        mShader = new LinearGradient(0,0,500,500,new int[]{Color.RED, Color.BLUE, Color.GREEN}, new float[]{0.f, 0.7f, 1}, Shader.TileMode.CLAMP);
//
//        // 设置给画笔
//        mPaint.setShader(mShader);
//
//        // 画一个圆
//        //canvas.drawCircle(250, 250, 250, mPaint);
//        canvas.drawRect(0,0, 500,500,mPaint);


        // 环形渲染

//        // 定义渲染器
//        mShader = new RadialGradient(250,250,250,new int[]{Color.RED, Color.BLUE, Color.GREEN}, null, Shader.TileMode.CLAMP);
//
//        // 设置给画笔
//        mPaint.setShader(mShader);
//
//        // 画一个圆
//        canvas.drawCircle(250, 250, 250, mPaint);


        // 环形渲染

//        // 定义渲染器
//        mShader = new SweepGradient(250,250, Color.RED, Color.GREEN);
//
//        // 设置给画笔
//        mPaint.setShader(mShader);
//
//        // 画一个圆
//        canvas.drawCircle(250, 250, 250, mPaint);



        // 位图渲染
//        mShader = new BitmapShader(mMBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
//        mPaint.setShader(mShader);
////        canvas.drawCircle(250, 250, 250, mPaint);
//        canvas.drawRect(0,0,500, 500, mPaint);


        // 组合渲染
        BitmapShader bitmapShader = new BitmapShader(mMBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        LinearGradient linearGradient = new LinearGradient(0,0,1000, 1600, new int[]{Color.RED, Color.GREEN, Color.BLUE}, null, Shader.TileMode.CLAMP);
        mShader = new ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.MULTIPLY);
        mPaint.setShader(mShader);
        canvas.drawCircle(250, 250, 250, mPaint);
    }
}
