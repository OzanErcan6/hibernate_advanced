package com.ozzyjpa.demojpa.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="product")
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name="name")
        private String name;

        @ElementCollection
        @CollectionTable(name="product_image")
        @OrderColumn
        @Column(name="file_name")
        private List<String> productImages = new ArrayList<>();

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImages() {
        return productImages;
    }

    public void setImages(List<String> productImages) {
        this.productImages = productImages;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images=" + productImages +
                '}';
    }
}
