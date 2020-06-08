package com.example.demo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<Customer> customers;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setUsers(Collection<Customer> customers) {
        this.customers = customers;
    }
}


