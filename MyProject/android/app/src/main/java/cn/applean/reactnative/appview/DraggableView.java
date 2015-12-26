package cn.applean.reactnative.appview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by songximing on 15/12/25.
 */
public class DraggableView extends View {
      /* (non-Javadoc)
         * @see android.view.View#onDraw(android.graphics.Canvas)
         */

    protected float currentx = 0;// 拖拽控件的x坐标
    protected float currenty = 0;// 拖拽控件的y坐标
    private int r = 0;//拖拽球的半径
    private boolean state = false;//判断控件是否应该获得焦点
    private Paint paint = null;//画笔
    private static int ALPHA_1 = 50;//画笔的透明度为半透明
    private static int ALPHA_2 = 255;//画笔的透明度不透明
    private float downX = 0f;//判断是否移动了x
    private float downY = 0f;//判断是否移动了y
    private Context context = null;//上下文
    private DraggableView.ViewCallBack callBack = null;//回调

    public DraggableView(Context context, DraggableView.ViewCallBack callBack) {
        super(context);
        this.context = context;
        this.callBack = callBack;
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawView(canvas, 12, 11);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();//获取点击的横坐标
        float y = event.getY();//获取点击的纵坐标

        //触摸事件的触发
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://触摸点击动作
                downX = x;
                downY = y;
                if (!isOption(x, y)) {
                    state = false;
                    return false;
                } else {
                    paint.setAlpha(ALPHA_2);
                    this.invalidate();
                    state = true;
                }
                break;
            case MotionEvent.ACTION_MOVE://触摸移动动作
                if (state) {
                    viewMove(x, y, event);
                    this.invalidate();
                }
                break;
            case MotionEvent.ACTION_UP://触摸离开动作
                paint.setAlpha(ALPHA_1);//设置画笔为半透明
                this.invalidate();
                if(downX == x&&downY==y){
                    callBack.finishActivity(context);
                }
                break;

        }
        return true;
    }

    /**
     * 画控件
     *
     * @param canvas 画板
     * @param with   控件的宽度比例
     * @param heigh  控件的高度比例
     */

    private void drawView(Canvas canvas, int with, int heigh) {

        if (getWidth() < getHeight()) {
            r = getWidth() / with;
        } else {
            r = getHeight() / heigh;
        }
        //如果是第一次画,画起始位置
        if (currentx == 0 && currenty == 0) {
            currentx = getWidth() - r;
            currenty = getHeight() - 3 * r;
            paint.setAlpha(ALPHA_1);
        }
        //用画笔画一个圆球控件
        canvas.drawCircle(currentx, currenty, r, paint);
    }

    /**
     * 初试化画笔
     */
    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.RED);//设置画笔的颜色
    }

    /**
     * 设置滑动的效果
     *
     * @param x     点击的x坐标轴
     * @param y     点击的y坐标轴
     * @param event 控件的事件
     */
    private void viewMove(float x, float y, MotionEvent event) {
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
    }

    /**
     * 判断是不是在控件可操作的范围之内
     *
     * @param x 点击的x坐标轴
     * @param y 点击的y坐标轴
     */
    private boolean isOption(float x, float y) {
        if (x > currentx - r && x < currentx + r && y < currenty + r & y > currenty - r)
            return true;
        else
            return false;
    }


    public interface ViewCallBack {
        public void finishActivity(Context context);
    }
}
