package com.blood.jetpackdemo.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.blood.jetpackdemo.R;

public class CustomViewA extends View {

    private static final String TAG = "CustomViewA";

    private int mWidth;
    private int mHeight;
    private Bitmap mBitmap;

    private int mDrawableId;

    public CustomViewA(Context context) {
        this(context, null);
    }

    public CustomViewA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        Log.i(TAG, "CustomViewA: ");
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.i(TAG, "CustomViewA: onFinishInflate");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, "CustomViewA: onAttachedToWindow");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i(TAG, "CustomViewA: onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i(TAG, "CustomViewA: onDraw");
        canvas.drawBitmap(mBitmap, 0, 0, null);
    }

    public void setBitmap(int drawableId) {
        mDrawableId = drawableId;
        Log.i(TAG, "setBitmap: " + drawableId);
    }
}
