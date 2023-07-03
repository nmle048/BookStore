package com.minhle.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "discount_codes")
public class DiscountCode {

    @Id
    @GeneratedValue
    @Column(name = "discount_code_id")
    private int discountCodeId;

    private String code;

    private int percentage;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(
            mappedBy = "discount_code",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders;
}
