package com.example.fabio.circleboundarylimited;


import android.content.*;
import android.graphics.*;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.*;
import android.view.*;

/**
 * Created by Fabio on 31/01/2017.
 */

public class MovableCircleWidget extends View {
    private int circle_x,circle_y,circle_radius,speed,w,h;
    private Paint paint;

    public MovableCircleWidget(Context context, AttributeSet attrs){
        super(context,attrs);
        paint=new Paint();
        circle_radius=20;
        speed=20;
        circle_x=circle_y=circle_radius;
    }

    @Override
    protected void onDraw(Canvas c){
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        c.drawRect(new Rect(0,0,this.getWidth(),this.getHeight()), paint);
        paint.reset();
        c.drawCircle(circle_x, circle_y, circle_radius, paint);
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        MeasureSpec.getSize()
        int size = 0;
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();



        if (width > height) {
            size = height;
        } else {
            size = width;
        }
        setMeasuredDimension(size, size);
    }

    public void up(){
        int new_circle_y=circle_y-speed;
        if(checkIfValidPosition(circle_x,new_circle_y)) circle_y-=speed;
    }

    public void down(){
        Log.d("DEBUG", ""+circle_y);
        int new_circle_y=circle_y+speed;
        Log.d("DEBUG", ""+new_circle_y);
        if(checkIfValidPosition(circle_x,new_circle_y)) circle_y+=speed;
    }

    public void dx(){
        int new_circle_x=circle_x+speed;
        if(checkIfValidPosition(new_circle_x,circle_y)) circle_x+=speed;
    }

    public void sx(){
        int new_circle_x=circle_x-speed;
        if(checkIfValidPosition(new_circle_x,circle_y)) circle_x-=speed;
    }

    public void center(){
        circle_x=this.getWidth()/2;
        circle_y=this.getHeight()/2;
    }

    private boolean checkIfValidPosition(int x, int y){
        return ((x>=0+circle_radius && x<this.getWidth()-circle_radius) && (y>=0+circle_radius && y<this.getHeight()-circle_radius));
    }
}
