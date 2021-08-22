package com.example.mydraw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyView mv;
    int color = Color.BLACK;
    int type = 1; // 1: 직선  , 2: 사각형, 3: 원 , 4: 타원
    class MyView extends View{
        Paint p;

        MyView(Context c){
            super(c);
            p = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10);
            p.setColor(color);
            if(type == 1)
            canvas.drawLine(20,40,300,370,p);
            else if(type == 2)
                canvas.drawRect(20,40,300,370,p);
            else if(type == 3)
                canvas.drawCircle(200,400,100, p);
            else if(type == 4)
                canvas.drawOval(20,40,300,370,p);

            /*
            canvas.drawOval(100, 150, 400,500,p);
            canvas.drawLine(170, 220,220,220,p);
            canvas.drawLine(280, 220,330,220,p);

            p.setColor(Color.GREEN);
            canvas.drawLine(250,290, 230, 350,p);
            canvas.drawLine(226,350,250,350,p);

            p.setColor(Color.GRAY);
            canvas.drawLine(190, 270, 210, 270 ,p );
            canvas.drawLine(290, 270, 310, 270 ,p );

            p.setColor(Color.YELLOW);
            canvas.drawCircle(200, 270, 25, p);
            canvas.drawCircle(300, 270, 25, p);
            canvas.drawLine(225,270,275,270,p);

            p.setColor(Color.MAGENTA);
            canvas.drawOval(200, 380, 300, 420, p);
*/
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv = new MyView(this);
        setContentView(mv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,101,0,"빨간색");
        menu.add(0,102,0,"파란색");
        menu.add(0,103,0,"녹색");
        SubMenu sm;
        sm = menu.addSubMenu("기타색");
        sm.add(0,201,0,"노란색");
        sm.add(0,202,0,"하늘색");
        sm.add(0, 203, 0, "분홍색");

        sm = menu.addSubMenu("내가 좋아하는 색");
        sm.add(0,301,0,"보라");
        sm.add(0,302,0,"네이비");
        sm.add(0,303,0,"베이지");
        
        sm = menu.addSubMenu("도형 선택");
        sm.add(0,401,0,"직선");
        sm.add(0,402,0,"사각형");
        sm.add(0,403,0,"원");
        sm.add(0,404,0,"타원");
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 101:
                color = Color.RED;
                mv.invalidate();
                break;

            case 102:
                color = Color.BLUE;
                mv.invalidate();
                break;

            case 103:
                color = Color.GREEN;
                mv.invalidate();
                break;

            case 201:
                color = Color.YELLOW;
                mv.invalidate();
                break;

            case 202:
                color = Color.CYAN;
                mv.invalidate();
                break;

            case 203:
                color = Color.MAGENTA;
                mv.invalidate();
                break;

            case 301:
                color = Color.rgb(128,65,255);
                mv.invalidate();
                break;

            case 302:
                color = Color.rgb(0,0,128);
                mv.invalidate();
                break;

            case 303:
                color = Color.rgb(236,230,204);
                mv.invalidate();
                break;
            case 401:
                type = 1;
                mv.invalidate();
                break;

            case 402:
                type = 2;
                mv.invalidate();
                break;

            case 403:
                type = 3;
                mv.invalidate();
                break;

            case 404:
                type = 4;
                mv.invalidate();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}