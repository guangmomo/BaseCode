package com.xuliwen.basecode.javacode.xuliehua.serializable;

import android.util.Log;

import com.xuliwen.basecode.utils.L;

import java.io.Serializable;

/**
 * Created by xlw on 2017/6/2.
 */

public class Student extends Person implements Serializable {
    public static int height=175;
    private int age;
    private String name;

    public Student(String gender) {
        super(gender);
        L.l("Student(String gender)");
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", gender=" + gender +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}
