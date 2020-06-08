package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity
@Table(name = "order_DB")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private double subtotal;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Customer_Id")
    private Customer customer;

    @OneToMany(mappedBy = "Order_ID", cascade = CascadeType.ALL)
    private Set<Product> products;

    public Order() {
    }

    public Order(@NotEmpty double subtotal, Customer customer, Set<Product> products) {
        this.subtotal = subtotal;
        this.customer = customer;
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products.add(products);
    }

    public long getId() {
        return id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}