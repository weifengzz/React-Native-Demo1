package com.myproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.facebook.react.ReactRootView;

/**
 * Created by songximing on 15/12/23.
 */
public class MyReactRootView extends ReactRootView {

    private Paint picPaint = null;//draw Paint


    public MyReactRootView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
    }

    public MyReactRootView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * init paint
     */
    private void initPaint() {
        picPaint = new Paint();
        picPaint.setColor(Color.BLUE);
        picPaint.setStrokeWidth(50);
        picPaint.setAntiAlias(true);
        picPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircle(canvas);
    }

    private void drawCircle(Canvas canvas) {
        canvas.drawLine(100,100,100,300,picPaint);
    }


    public MyReactRootView(Context context) {
        this(context, null);
    }


}
