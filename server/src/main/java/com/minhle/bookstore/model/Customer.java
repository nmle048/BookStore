package com.minhle.bookstore.model;

import com.minhle.bookstore.security.model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private int customerId;

    private String name;

    private String email;

    private String address;

    private String phone;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private User user;
}
