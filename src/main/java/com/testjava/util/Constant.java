package com.testjava.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by erwin on 4/1/18.
 */
public interface Constant {

    Map<Integer, String> status = new HashMap<Integer, String>() {{
        put(0, "ORDERED");
        put(1, "VALID");
        put(2, "INVALID PAYMENT METHOD");
        put(3, "OUT OF STOCK");
        put(4, "INVALID ADDRESS");
        put(5, "SHIPPED");
    }};
}
