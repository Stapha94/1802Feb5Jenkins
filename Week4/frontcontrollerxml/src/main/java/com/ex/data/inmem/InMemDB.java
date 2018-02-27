package com.ex.data.inmem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by August on 6/17/2017.
 */
public abstract class InMemDB<K, V> {
    protected Map<K, V> data = new ConcurrentHashMap<>();
    protected boolean opened;

    public abstract V get(K key);
    public abstract boolean set(K key, V value);
    public abstract boolean open();
    public abstract void close();
    public abstract void remove(K key);
    public abstract void clear();
}
