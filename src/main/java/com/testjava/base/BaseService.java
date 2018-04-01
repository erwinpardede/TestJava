package com.testjava.base;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by erwin on 3/30/18.
 */
public class BaseService<T> implements IBaseService<T> {

    protected List<T> objects = new ArrayList<T>();

    public List<T> get() {

        return this.objects;
    }

    public T get(T object) {

        for (T objectz : this.objects) {
            if (objectz.equals(object)) {
                return objectz;
            }
        }
        return null;
    }

    public Integer save(T object) {

        this.objects.add(object);
        return 1;
    }

    public Integer update(T object) {
        for (T objectz : this.objects) {
            if (objectz.equals(object)) {
                try {
                    BeanUtils.copyProperties(objectz, object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return 1;
            }
        }
        return 0;
    }

    public Integer delete(T object) {
        for (T objectz : this.objects) {
            if (objectz.equals(object)) {
                this.objects.remove(objectz);
                return 1;
            }
        }
        return 0;
    }
}
