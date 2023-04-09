package edu.depaul.cdm.se452.products.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public static class Product {
    }
}
