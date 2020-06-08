package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoder implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public void run(String... Strings) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        Customer customer1 = new Customer("Eyob", "Amenu", "1 Circle Ave",
                "eyob@123", 1234567890, "Eyob");
        customer1.setRoles(Arrays.asList(adminRole));
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Ronald", "Ronald", "1 Circle Ave",
                "ronald@123", 1987654320, "Ronald");
        customer1.setRoles(Arrays.asList(adminRole));
        customerRepository.save(customer1);

        

    }
}
