package com.test.tree.set;

import com.test.model.Order;
import java.util.Set;

public class TestTreeSet {

    public static void printOrder(Set<Order> list) {
        for(Order order : list) {
            System.out.println(order);
        }
        System.out.println();
    }
}
