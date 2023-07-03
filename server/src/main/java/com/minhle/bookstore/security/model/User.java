package com.minhle.bookstore.security.model;

import com.minhle.bookstore.model.Customer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;

    private String username;

    private String password;

    @Column(name = "created_at")
    private Date createdAt = new Date();

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
