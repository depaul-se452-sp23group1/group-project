package edu.depaul.cdm.se452.products.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public static class Product {
    }
}
