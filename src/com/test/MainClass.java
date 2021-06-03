package com.test;

import com.test.array.list.TestArrayList;
import com.test.linkedlist.TestLinkedList;
import com.test.map.TestHashMap;
import com.test.map.TestTreeMap;
import com.test.model.Customer;
import com.test.model.Order;
import com.test.model.PaymentRequest;
import com.test.model.PaymentState;
import com.test.thread.FibonacciThread;
import com.test.thread.TestThreadOne;
import com.test.thread.TestThreadTwo;
import com.test.thread.ThreadCounter;
import com.test.tree.set.TestTreeSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) throws ParseException, InterruptedException {
        Customer customer1 = new Customer("venkatesh", "para", "venky.para@gmail.com", 35);
        Customer customer2 = new Customer("saket", "vetri", "saket.vetri@gmail.com", 10);
        Customer customer3 = new Customer("maran", "siva", "maran.siva@gmail.com", 45);
        Customer customer4 = new Customer("ganesh", "rakesh", "ganesh.rakesh@gmail.com", 20);
        Customer customer5 = new Customer("ganesh", "guru", "ganesh.guru@gmail.com", 11);
        Customer customer6 = new Customer("satish", "bala", "satish.bala@gmail.com", 50);
        Customer customer7 = new Customer("pradeep", "chakra", "pradeep.chakra@gmail.com", 25);

        Order order1 = new Order("1", 100, customer1, getDate("2021-01-01"));
        Order order2 = new Order("2", 200, customer2, getDate("2021-05-01"));
        Order order3 = new Order("3", 300, customer1, getDate("2021-04-20"));
        Order order4 = new Order("4", 400, customer2, getDate("2021-01-25"));

        // -------------------  ARRAY LIST ------------
        List<Customer> customerArrayList =
                new ArrayList<>(Arrays.asList(customer1, customer2, customer3, customer4, customer5));

        // Filter the array contents based on First name (ex firstname like ‘%Virtusa%’)
        List<Customer> filteredListBasedOnFirstName = TestArrayList
                .filterContentsBasedOnFirstName("ganesh", customerArrayList);
        System.out.println("Filtered list based on firstName 'Ganesh': ");
        TestArrayList.print(filteredListBasedOnFirstName);

        // Add another list to the current list
        List<Customer> customerArrayListSecond = new ArrayList<>(Arrays.asList(customer6, customer7));
        customerArrayList.addAll(customerArrayListSecond);

        System.out.println("Current list after adding second list: ");
        TestArrayList.print(customerArrayList);

        // Find an element based on hashcode & equals comparison.
        Customer customerToBeSearched =
                new Customer("pradeep", "chakra", "pradeep.chakra@gmail.com", 25);
        Optional<Customer> findResult = TestArrayList.findElement(customerToBeSearched, customerArrayList);
        if(findResult.isPresent()) {
            System.out.println("FindElement found customer: " + findResult.get());
        }

        // -------------------------- TREE SET -----------------------------
        Set<Order> orderTreeSet = new TreeSet<>((a, b) -> a.getCreatedDate().compareTo(b.getCreatedDate()));
        orderTreeSet.addAll(Arrays.asList(order1, order2, order3, order4));

        // store and sort an Order Object collection by using TreeSet.
        System.out.println("Printing orders sorted by order creation date: ");
        TestTreeSet.printOrder(orderTreeSet);

        // Show case the duplicates objects are not allowed in the collection
        Order duplicateOrder = new Order("1", 100, customer1, getDate("2021-01-01"));
        if(!orderTreeSet.add(duplicateOrder)) {
            System.out.println("Unable to add duplicate order into the set");
        }

        // -------------------------- HASHMAP -----------------------------
        System.out.println("-------------------------- HASHMAP -----------------------------");
        Map<String, Order> orderMap = new HashMap<>();

        orderMap.put(order1.getId(), order1);
        orderMap.put(order2.getId(), order2);
        orderMap.put(order3.getId(), order3);
        orderMap.put(order4.getId(), order4);

        // Check the existence of Key in the map
        if(orderMap.containsKey(order2.getId())) {
            System.out.println("Contains key: " + order2.getId());
        }

        // Check the existence of an matching object in the value part
        if(orderMap.containsValue(order2)) {
            System.out.println("Order 2 value exist: " + order2);
        }

        // Show case, the key can be null once, and value can hold multiple nulls
        orderMap.put(null, order1);
        orderMap.put("5", null);
        orderMap.put("6", null);
        orderMap.put("7", null);

        // Iterate the Map using EnterySet and Iterator methods
        TestHashMap.print(orderMap);

        // -------------------------- TREEMAP -----------------------------
        System.out.println("-------------------------- TREEMAP -----------------------------");
        Map<Date, Order> orderTreeMap = new TreeMap<>();
        orderTreeMap.put(order1.getCreatedDate(), order1);
        orderTreeMap.put(order2.getCreatedDate(), order2);
        orderTreeMap.put(order3.getCreatedDate(), order3);
        orderTreeMap.put(order4.getCreatedDate(), order4);
        TestTreeMap.print(orderTreeMap);

        // -------------------------- LINKED LIST -----------------------------
        System.out.println("-------------------------- LINKED LIST -----------------------------");
        Map<PaymentRequest, LinkedList<PaymentState>> paymentRequestMap = new HashMap<>();
        PaymentRequest paymentRequest = new PaymentRequest("1", customer1);
        PaymentRequest paymentRequest1 = new PaymentRequest("2", customer2);
        PaymentRequest paymentRequest2 = new PaymentRequest("3", customer3);
        PaymentRequest paymentRequest3 = new PaymentRequest("4", customer4);

        paymentRequestMap.put(paymentRequest, new LinkedList<>(Arrays.asList(PaymentState.PAYMENT_INITIATED)));
        paymentRequestMap.put(paymentRequest1, new LinkedList<>(Arrays.asList(PaymentState.PAYMENT_INITIATED)));
        paymentRequestMap.put(paymentRequest2, new LinkedList<>(Arrays.asList(PaymentState.PAYMENT_INITIATED)));
        paymentRequestMap.put(paymentRequest3, new LinkedList<>(Arrays.asList(PaymentState.PAYMENT_INITIATED)));

        // Print the first and last items in the list , for the given payment request
        TestLinkedList.printFirstAndLastPaymentState(paymentRequest, paymentRequestMap);

        // Insert an element at an given position to the existing linked list
        LinkedList<PaymentState> paymentStates = paymentRequestMap.get(paymentRequest);
        paymentStates.add(1, PaymentState.BENE_ACCOUNT_CREDITED);
        paymentStates.add(1, PaymentState.PAYMENT_COMPLETED_SUCESS);
        TestLinkedList.printFirstAndLastPaymentState(paymentRequest, paymentRequestMap);

        // Remove the first and last element.
        paymentStates.removeFirst();
        paymentStates.removeLast();
        TestLinkedList.printFirstAndLastPaymentState(paymentRequest, paymentRequestMap);

        // Display the counter and name of the Threads in a test class by accessing two different threads -
        //one of the class extends Thread and the other implements Runnable
        TestThreadOne testThreadOne = new TestThreadOne();
        testThreadOne.start();
        TestThreadOne testThreadOne1 = new TestThreadOne();
        testThreadOne1.start();
        TestThreadOne testThreadOne2 = new TestThreadOne();
        testThreadOne2.start();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new TestThreadTwo());
        executorService.submit(new TestThreadTwo());
        executorService.submit(new TestThreadTwo());
        executorService.shutdown();

        //Count the number of Leaf nodes in a Tree
        long count = orderTreeSet.stream().count();
        System.out.println("Print tree count : " + count);

        // write a method that returns a list of all strings that start with the letter 'a' (lower case)
        //and have exactly 3 letters
        List<String> inputList = new ArrayList<>();
        inputList.add("venkatesh");
        inputList.add("arun");
        inputList.add("avinash");
        inputList.add("surya");
        inputList.add("aru");
        inputList.add("avi");
        List<String> resultList = inputList.stream().filter(cur -> cur.startsWith("a") && cur.length() == 3)
                .collect(Collectors.toList());
        System.out.println("string starts with a and have exactly 3 chars: " + resultList);

        // Use join() method in such way that println() method to be run after calculating fibonnaci series
        FibonacciThread fibonacciThread = new FibonacciThread();
        fibonacciThread.start();
        fibonacciThread.join();
        System.out.println();

        // Implement a thread Counter which will take a CountDownLatch
        System.out.println("Implement a thread Counter which will take a CountDownLatch");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ThreadCounter threadCounter = new ThreadCounter(countDownLatch, 3);
        threadCounter.start();
        countDownLatch.await();
        System.out.println("Program ends here");
    }

    public static Date getDate(String dateString) throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateObject = sdf.parse(dateString);
        return dateObject;
    }
}
