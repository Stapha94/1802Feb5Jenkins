package com.ex.services;

import java.io.BufferedReader;
import java.io.Reader;

/**
 * Created by August Duet on 6/16/2017.
 */
public interface DataSerializer{
    Object deserialize(Reader src, Class clazz);
    Object serialize(Object src);
}
