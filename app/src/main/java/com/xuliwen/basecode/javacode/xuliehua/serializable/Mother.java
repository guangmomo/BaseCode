package com.xuliwen.basecode.javacode.xuliehua.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by xlw on 2017/6/4.
 */

public class Mother implements Serializable {
    private int age;
    private String name;

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
       //  outputStream.defaultWriteObject();
        //  outputStream.writeObject(name);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
     //  inputStream.defaultReadObject();
        // this.name= (String) inputStream.readObject();
    }

    private void readObjectNoData(){

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
        return "Mother{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
