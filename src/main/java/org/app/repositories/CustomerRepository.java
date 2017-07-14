package org.app.repositories;

import org.app.models.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Author:  andreicovaciu;
 * Date:    25-Jan-17.
 * <p>
 * HAPPY CODING!
 */
public interface CustomerRepository extends CrudRepository<Customer, String> {
    Customer findByEmail(String email);
}
