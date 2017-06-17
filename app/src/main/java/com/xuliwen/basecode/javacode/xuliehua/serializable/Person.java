package com.xuliwen.basecode.javacode.xuliehua.serializable;

import com.xuliwen.basecode.utils.L;

import java.io.Serializable;

/**
 * Created by xlw on 2017/6/2.
 */

public class Person  {


    public Person(){
        L.l("Person()");
    }

    public Person(String gender){
        this.gender=gender;
        L.l("Person(String gender)");

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

     String gender;

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                '}';
    }
}
