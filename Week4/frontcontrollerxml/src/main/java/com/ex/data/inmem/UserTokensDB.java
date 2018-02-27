package com.ex.data.inmem;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by August on 6/17/2017.
 */
public class UserTokensDB extends InMemDB<String, Object> {

    private long keyExpiry;

    public UserTokensDB(){
        this.keyExpiry = 3600;
    }

    public UserTokensDB(long keyExpiry){
        this.keyExpiry = keyExpiry;
    }

    @Override
    public Object get(String key) {
        if(opened) {
            Principal p = (Principal)data.get(key);
            if(p != null){
                return p.getValue();
            }
            return null;
        }
        throw new IllegalStateException("UserTokenDB is not in a readable state");
    }

    @Override
    public boolean set(String key, Object value) {
        if(opened){
            Principal p = new Principal(value);
            Principal v = (Principal) data.put(key, p);

            return (v != null);
        }
        throw new IllegalStateException("UserTokenDB is not in a writeable state");
    }

    @Override
    public boolean open() {
        new Thread(()->{
            while(opened){
                Iterator<Map.Entry<String, Object>> itr = data.entrySet().iterator();

                while(itr.hasNext()){
                    Principal p = (Principal)itr.next().getValue();
                    long curTime = new Date().getTime();
                    long diff = (curTime - p.getCreationTime()) / 1000;

                    if(diff > this.keyExpiry){
                        itr.remove();
                    }
                }
            }
        }).start();
        return  (opened = true);
    }

    @Override
    public void close() {
        opened = false;
    }

    @Override
    public void remove(String key){
        data.remove(key);
    }

    @Override
    public void clear(){
        data.clear();
    }

    public boolean refresh(String key){
        Principal p = (Principal) this.get(key);

        if(p == null){
            return false;
        }else{
            this.set(key, p);
        }
        return true;
    }

    public boolean isOpen(){
        return opened;
    }

    public boolean isClose(){
        return !opened;
    }

    public long getKeyExpiry(){
        return keyExpiry;
    }
}
