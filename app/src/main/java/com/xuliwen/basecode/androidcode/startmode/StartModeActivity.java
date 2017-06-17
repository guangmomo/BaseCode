package com.xuliwen.basecode.androidcode.startmode;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.xuliwen.basecode.Constants;
import com.xuliwen.basecode.R;
import com.xuliwen.basecode.utils.L;

public class StartModeActivity extends BaseActivity {

    private EditText testEditText;
    private CustomSwitch customSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_mode);

        testEditText= (EditText) findViewById(R.id.test_editText);
        customSwitch= (CustomSwitch) findViewById(R.id.customSwitch);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("testEditText",testEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text=savedInstanceState.getString("testEditText");
        if(text!=null){
            testEditText.setText(text);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        //不要在onPause中做耗时任务，这样会导致Activity跳转变慢，如果一定要在Activity跳转的时候在UI
        //线程中做耗时任务，请放在onStop中进行
//        try {
//            Thread.sleep(3*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void standard(View view) {
        startActivity(new Intent(this,StandardActivity.class));
    }

    public void dialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("我是Dialog");
        builder.show();
    }

    public void setCustomState(View view) {
        customSwitch.setCustomState(12);
    }

    public void getCustomState(View view) {
        L.l("customSwitch customState"+customSwitch.getCustomState());
    }


    public void toAllowTaskReparentingActivity(View view) {
        Intent intent=new Intent("com.xuliwen.basecode1.androidcode.startcode.AllowTaskReparentingActivity");
        intent.setPackage(Constants.PKG1);
        startActivity(intent);
    }


    public void toSingeTopActivity(View view) {
        Intent intent=new Intent(new Intent(this,SingleTopActivity.class));
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void toSingleTaskActivity(View view) {
        Intent intent=new Intent(this,SingleTaskActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        startActivity(intent);
    }


    public void toSingleInstanceActivity(View view) {
        startActivity(new Intent(this,SingleInstanceActivity.class));
    }

    public void toServiceActivity(View view) {
        startService(new Intent(this,MyService.class));
    }

    public void toClearActivity(View view) {
        startActivity(new Intent(this,ClearActivity.class));
    }

    public void toActivityCD(View view) {
            Intent intent=new Intent("com.xuliwen.basecode1.androidcode.startcode.ActivityC");
        startActivity(intent);
    }
}
