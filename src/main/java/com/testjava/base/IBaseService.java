package com.testjava.base;

import java.util.List;

/**
 * Created by erwin on 3/30/18.
 */
public interface IBaseService<T> {

    public List<T> get();
    public T get(T Object);
    public Integer save(T Object);
    public Integer update(T Object);
    public Integer delete(T Object);
}
