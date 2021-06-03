package com.test.array.list;

import com.test.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestArrayList {

    public static List<Customer> filterContentsBasedOnFirstName(String firstName, List<Customer> customerList) {
        List<Customer> filteredCustomerList = new ArrayList<>();
        for(Customer customer : customerList) {
            if(firstName.equals(customer.getFirstName())) {
                filteredCustomerList.add(customer);
            }
        }
        return filteredCustomerList;
    }

    public static Optional<Customer> findElement(Customer customerToBeSearched, List<Customer> customerList) {
        for(Customer customer : customerList) {
            if(customerToBeSearched.equals(customer)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public static void print(List<Customer> list) {
        for(Customer customer : list) {
            System.out.println(customer);
        }
        System.out.println();
    }
}
