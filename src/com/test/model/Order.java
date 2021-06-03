package com.test.model;

import java.util.Date;
import java.util.Objects;

public class Order {
    private String id;
    private int amount;
    private Customer customer;
    private Date createdDate;

    public Order(String id, int amount, Customer customer, Date createdDate) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", customer=" + customer +
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return amount == order.amount && id.equals(order.id) && customer.equals(order.customer) && createdDate.equals(order.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, customer, createdDate);
    }
}
