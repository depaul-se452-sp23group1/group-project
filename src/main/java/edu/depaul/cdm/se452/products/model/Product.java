package edu.depaul.cdm.se452.products.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String manufacturer;
    private String name;
    private int price;

    public Product(String name, double price, String manufacturer) {
        this.name = name;
        this.price = (int) price;
        this.manufacturer = manufacturer;
    }

    public Product(long id, String name, double price, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = (int) price;
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return null;
    }
}
