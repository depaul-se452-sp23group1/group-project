package edu.depaul.cdm.se452.orders.model;

import edu.depaul.cdm.se452.products.model.Product;

import java.util.List;

public class Order {
private long id;
private List<Product> productsList;

private double subtotal;
private double tax;
private double shipping;
private double total;
private String status;
}
