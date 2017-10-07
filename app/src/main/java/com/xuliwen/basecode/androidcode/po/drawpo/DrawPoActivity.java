package com.xuliwen.basecode.androidcode.po.drawpo;

import android.os.Build;
import android.os.Debug;
import android.os.Trace;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xuliwen.basecode.R;

public class DrawPoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_po);
    }

    private void fun1(){
        for(int y=0; y<100;){
            y++;
        }
        fun2();
    }

    private void fun2(){
        for(int y=0; y<1000;){
            y++;
        }
    }

    private void fun3(){
        for(int y=0; y<10000;){
            y++;
        }
        fun4();
    }

    private void fun4(){
        for(int y=0; y<20000;){
            y++;
        }
    }

    private void fun5(){
        for(int y=0; y<30000;){
            y++;
        }
        fun4();
    }

    public void traceView(View view) {
        Debug.startMethodTracing("toStandardActivity");
        fun1();
        fun2();
        fun3();
        fun4();
        fun5();
        Debug.stopMethodTracing();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void sysTrace(View view) {
        Trace.beginSection("sysTraceTest");
        sleep();
        Trace.endSection();
    }

    private void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
