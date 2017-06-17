package com.xuliwen.basecode.javacode.xuliehua.serializable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xuliwen.basecode.R;
import com.xuliwen.basecode.androidcode.database.*;
import com.xuliwen.basecode.utils.L;
import com.xuliwen.basecode.utils.SDCardUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableActivity extends AppCompatActivity {
    private String filePath= SDCardUtils.getSDCardPath()+"Serializable.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializable);
    }


    public void serializable(View view) {
        Student student1=new Student("男");
        student1.setAge(22);
        student1.setName("徐立文");
        student1.setGender("男");

        Student student2=new Student("女");
        student2.setAge(24);
        student2.setName("徐文书");

        Father father=new Father();
        father.setAge(45);
        father.setName("徐建祥");

        Teacher teacher=new Teacher();
        teacher.setName("黄丽娟");
        teacher.setAge(30);
        teacher.setStudent(student1);

        Mother mother=new Mother();
        mother.setName("王菲");
        mother.setAge(45);

        ObjectOutputStream objectOutputStream=null;
        try {
             objectOutputStream=new ObjectOutputStream(new FileOutputStream(filePath));
             objectOutputStream.writeObject(mother);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        L.l("Serializable写入对象");
    }

    public void deSerializable(View view) {
        ObjectInputStream objectInputStream=null;
        try {

            objectInputStream=new ObjectInputStream(new FileInputStream(filePath));

            Mother mother= (Mother) objectInputStream.readObject();
            L.l("Serializable读取Mother： "+mother);

//            Student student1= (Student) objectInputStream.readObject();
//            L.l("Serializable读取Student1： "+student1);

//            Student student2= (Student) objectInputStream.readObject();
//            L.l("Serializable读取Student2： "+student2);

//            Teacher teacher= (Teacher) objectInputStream.readObject();
//            L.l("Serializable读取Teacher： "+teacher);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
