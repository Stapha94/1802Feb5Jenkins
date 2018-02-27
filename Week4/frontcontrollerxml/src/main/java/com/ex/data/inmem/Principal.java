package com.ex.data.inmem;

import java.util.Date;
import java.util.Objects;

/**
 * Created by August on 6/18/2017.
 */
public class Principal {

    private Long creationTime;
    private Object value;

    public Principal(){
        this.creationTime = new Date().getTime();
    }

    public Principal(Object value){
        this();
        this.value = value;
    }

    public Object getValue(){
        return  this.value;
    }

    public void setValue(Object value){
        this.value = value;
    }

    public long getCreationTime(){
        return this.creationTime;
    }
}
