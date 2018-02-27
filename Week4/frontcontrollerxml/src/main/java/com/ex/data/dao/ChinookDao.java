package com.ex.data.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by August Duet on 6/1/2017.
 */
public interface ChinookDao<T, I extends Serializable> {
    List<T> getAll();
    T findOne(I id);
}
