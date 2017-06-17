package com.xuliwen.basecode.javacode.xuliehua.pacelable;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xuliwen.basecode.R;
import com.xuliwen.basecode.utils.L;
import com.xuliwen.basecode.utils.SDCardUtils;
import com.xuliwen.basecode.utils.StreamUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ParcelableActivity extends AppCompatActivity {

    private String filePath= SDCardUtils.getSDCardPath()+"Parcelable.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacelable);
    }

    public void parcelable(View view) {
        Person person=new Person(32,"勒布朗");
        byte[] personArray=ParcelableUtil.marshall(person);
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(filePath);
            fileOutputStream.write(personArray);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            StreamUtils.close(fileOutputStream);
        }
        L.l("Parcelable序列化Person到文件中");

    }

    public void deParcelable(View view) {
        Parcel parcel=null;
        FileInputStream fileInputStream=null;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] personArray=new byte[1024];
        try {
            fileInputStream=new FileInputStream(filePath);
            int length=-1;
            while ((length=fileInputStream.read(personArray))!=-1){
               byteArrayOutputStream.write(personArray,0,length);
            }
            parcel=ParcelableUtil.unMarshall(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            StreamUtils.closeList(fileInputStream,byteArrayOutputStream);
        }
        Person person=Person.CREATOR.createFromParcel(parcel);
        L.l("Parcelable从文件反序列化："+person);

    }

    public void intentPerson(View view) {
        Person person=new Person(22,"徐立文");
        Intent intent=new Intent(this,ReceiveParcelableActivity.class);
//        Intent intent=new Intent();
//        intent.setClassName(getPackageName(),"com.xuliwen.basecode.javacode.xuliehua.pacelable.ReceiveParcelableActivity");
        intent.putExtra("person",person);
        startActivity(intent);
    }
}
