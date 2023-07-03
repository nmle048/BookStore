package com.minhle.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private int bookId;

    private String title;

    private String description;

    private String author;

    private String translator;

    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private Calendar publicationDate;

    private int price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    private int weight;

    private int pages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> orderItems;
}
