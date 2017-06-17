package com.xuliwen.basecode.javacode.xuliehua.serializable;

import java.io.Serializable;

/**
 * Created by xlw on 2017/6/2.
 */

public class Teacher implements Serializable{
    private int age;
    private String name;
    private Student student;
   // private Father father; 由于Father是不可序列化的，所以Teacher也是不可序列化的，如果序列化Teacher，将会报Exception

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



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
