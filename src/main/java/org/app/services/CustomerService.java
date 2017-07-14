package org.app.services;

import org.app.models.Customer;
import org.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  andreicovaciu;
 * Date:    25-Jan-17.
 * <p>
 * HAPPY CODING!
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public boolean loginSuccessful(Customer customer) {
        Customer u = customerRepository.findByEmail(customer.getEmail());
        return u != null && BCrypt.checkpw(customer.getPlainPassword(), u.getEncryptedPassword());
    }

    public boolean save(Customer customer) {
        System.out.println(customer);
        if (customerRepository.findByEmail(customer.getEmail()) == null) {
            customer.setEncryptedPassword(BCrypt.hashpw(customer.getPlainPassword(), BCrypt.gensalt()));
            customer.setPlainPassword("");
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    public void remove(Customer customer) {
        customerRepository.delete(customer);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        System.out.println("CUSTOMERS = {\n");
        customers.forEach(System.out::println);
        System.out.println("}");
        return customers;
    }
}
