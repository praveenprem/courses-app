package org.app.controllers;

import org.app.models.Customer;
import org.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:  andreicovaciu;
 * Date:    25-Jan-17.
 * <p>
 * HAPPY CODING!
 */
@RestController
public class LoginController {

    @Autowired
    public CustomerService customerService;

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public boolean login(@RequestBody Customer customer) {
        return customerService.loginSuccessful(customer);
    }

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public boolean register(@RequestBody Customer customer) {
        Customer c = new Customer("", customer.getEmail(), customer.getPlainPassword());
        return customerService.save(c);
    }

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
