package com.ex.topsecret;

import com.ex.annotations.Gimme;

/**
 * Created by August Duet on 12/15/2016.
 */
public class TestClass2 {


    TestClass t;

    @Gimme
    public void setT(TestClass t){
        this.t = t;
    }

    public void doSomething(){
        t.print();
    }
}
