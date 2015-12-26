package com.myproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

        /* (non-Javadoc)
         * @see android.view.View#onDraw(android.graphics.Canvas)
         * Draw a ball for back
         */

    public float currentx = 0;// ball's X position
    public float currenty = 0;// ball's Y position
    private int r = 0;//球的半径
    private boolean state = false;
    private Paint paint = null;

    /**
     * @param context
     */
    public DrawView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        if (getWidth() < getHeight()) {
            r = getWidth() / 12;
        } else {
            r = getHeight() / 11;
        }

        //set paint color
        paint.setColor(Color.RED);
        //如果是第一次画,画起始位置
        if (currentx == 0 && currenty == 0) {
            currentx = getWidth() - r;
            currenty = getHeight() - 3 * r;
            paint.setAlpha(100);
        }
        //use paint to draw a RED ball
        canvas.drawCircle(currentx, currenty, r, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:

                if (state) {
                    if (x <= r) {
                        currentx = r;
                    } else if (x >= getWidth() - r) {
                        currentx = getWidth() - r;
                    } else if (y <= r) {
                        currenty = r;
                    } else if (y >= getHeight() - r) {
                        currenty = getHeight() - r;
                    } else {
                        currentx = event.getX();
                        currenty = event.getY();
                    }
                    this.invalidate();

                }
                break;
            case MotionEvent.ACTION_DOWN:
                paint.setAlpha(255);
                if (x > currentx - r && x < currentx + r && y < currenty + r & y > currenty - r) {
                    if (x <= r) {
                        currentx = r;
                    } else if (x >= getWidth() - r) {
                        currentx = getWidth() - r;
                    } else if (y <= r) {
                        currenty = r;
                    } else if (y >= getHeight() - r) {
                        currenty = getHeight() - r;
                    } else {
                        currentx = event.getX();
                        currenty = event.getY();
                    }
                    //通知Draw组件重绘 ;
                    state = true;
                } else {
                    state = false;
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
                paint.setAlpha(100);
                this.invalidate();
                break;
        }
        return true;
    }
}
