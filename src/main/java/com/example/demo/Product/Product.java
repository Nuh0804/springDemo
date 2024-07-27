package com.example.demo.Product;

import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Entity(name = "product")
@Table(
        name = "product",
        uniqueConstraints = {
                @UniqueConstraint(name = "name", columnNames = "name")
        }
)
public class Product {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
//            strategy = SEQUENCE,
            generator = "student_sequence",
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long Id;

    @Column(
            columnDefinition = "TEXT",
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            columnDefinition = "TEXT",
            name = "category",
            nullable = false
    )
    private String category;

    @Column(
            name = "price",
            nullable = false
    )
    private int price;

    @Column(
            name = "stock",
            nullable = false
    )
    private int stock;

    public Product(String name, String category, int price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public Product() {
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", Category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
