package edu.depaul.cdm.se452.products.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int categoryId;
    private String manufacturer;
    private String name;
    private double price;
}
