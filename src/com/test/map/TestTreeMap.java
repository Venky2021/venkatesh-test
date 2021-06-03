package com.test.map;

import com.test.model.Order;
import java.util.Date;
import java.util.Map;

public class TestTreeMap {
    public static void print(Map<Date, Order> orderMap) {
        for(Map.Entry<Date, Order> entry : orderMap.entrySet()) {
            System.out.print(entry.getKey() + "  :  " + entry.getValue());
            System.out.println();
        }
        System.out.println();
    }
}
