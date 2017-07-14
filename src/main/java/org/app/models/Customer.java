package org.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Author:  andreicovaciu;
 * Date:    25-Jan-17.
 * <p>
 * HAPPY CODING!
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;

    private String email;

    private String plainPassword;

    private String encryptedPassword;

    public Customer() {
    }

    public Customer(String email, String plainPassword) {
        this.email = email;
        this.plainPassword = plainPassword;
    }

    public Customer(String email, String plainPassword, String encryptedPassword) {
        this.email = email;
        this.plainPassword = plainPassword;
        this.encryptedPassword = encryptedPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", plainPassword='" + plainPassword + '\'' +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                '}';
    }
}
