package com.ex.services;

import com.google.gson.Gson;

import java.io.Reader;

/**
 * Created by August Duet on 6/16/2017.
 */
public class JsonSerializer implements DataSerializer {
    @Override
    public Object deserialize(Reader src, Class clazz) {
        return new Gson().fromJson(src, clazz);
    }

    @Override
    public String serialize(Object src) {
        return new Gson().toJson(src);
    }
}
