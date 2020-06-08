
package com.example.demo;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart_DB")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "Cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Product> products;

    public Cart() {
    }

    public Cart(Set<Product> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}