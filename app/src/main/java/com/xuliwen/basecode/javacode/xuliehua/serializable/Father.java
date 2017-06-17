package com.xuliwen.basecode.javacode.xuliehua.serializable;

/**
 * Created by xlw on 2017/6/2.
 */

public class Father {
    private int age;
    private String name;

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
        return "Father{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
