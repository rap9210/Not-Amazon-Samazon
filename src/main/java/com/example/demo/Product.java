package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "product_DB")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String product_type;

    @NotEmpty
    private String product_name;

    @NotEmpty
    private double price;

    @NotEmpty
    private boolean available;

    @OneToMany(mappedBy = "product_ID", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Order> orders;

    public Product() {
    }

    public Product(@NotEmpty String product_type, @NotEmpty String product_name,
                   @NotEmpty double price, @NotEmpty boolean available) {
        this.product_type = product_type;
        this.product_name = product_name;
        this.price = price;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
