package edu.depaul.cdm.se452.products.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    public Category(String name) {
        this.name = name;
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Entity
    @Table(name = "product")
    public static class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String manufacturer;

        @ManyToOne
        @JoinColumn(name = "category_id", referencedColumnName = "id")
        private Category category;

        private String name;
        private int price;
    }
}
