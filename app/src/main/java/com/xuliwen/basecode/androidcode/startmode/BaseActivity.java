package com.xuliwen.basecode.androidcode.startmode;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xuliwen.basecode.R;
import com.xuliwen.basecode.utils.L;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.l(this.getClass().getSimpleName()+":  "+"onCreate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        L.l(this.getClass().getSimpleName()+":  "+"onConfigurationChanged");
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        L.l(this.getClass().getSimpleName()+":  "+"onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        L.l(this.getClass().getSimpleName()+":  "+"onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        L.l(this.getClass().getSimpleName()+":  "+"onStart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        L.l(this.getClass().getSimpleName()+":  "+"onNewIntent");
    }

    @Override
    protected void onResume() {
        super.onResume();
        L.l(this.getClass().getSimpleName()+":  "+"onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        L.l(this.getClass().getSimpleName()+":  "+"onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        L.l(this.getClass().getSimpleName()+":  "+"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        L.l(this.getClass().getSimpleName()+":  "+"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        L.l(this.getClass().getSimpleName()+":  "+"onDestroy");
    }
}
