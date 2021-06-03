package com.test.map;

import com.test.model.Order;
import java.util.Map;

public class TestHashMap {
    public static void print(Map<String, Order> orderMap) {
        for(Map.Entry<String, Order> entry : orderMap.entrySet()) {
            System.out.print(entry.getKey() + "  :  " + entry.getValue());
            System.out.println();
        }
        System.out.println();
    }
}
