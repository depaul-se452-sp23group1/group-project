package edu.depaul.cdm.se452.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void testNoArgsConstructor() {
        assertNotNull(product);
    }

    @Test
    void testAllArgsConstructor() {
        Category category = new Category(1, "Electronics");
        Product newProduct = new Product(1, category, "Manufacturer", "Product Name", 100);

        assertNotNull(newProduct);
        assertEquals(1, newProduct.getId());
        assertEquals(category, newProduct.getCategory());
        assertEquals("Manufacturer", newProduct.getManufacturer());
        assertEquals("Product Name", newProduct.getName());
        assertEquals(100, newProduct.getPrice());
    }

    @Test
    void testId() {
        product.setId(1);
        assertEquals(1, product.getId());
    }

    @Test
    void testCategory() {
        Category category = new Category(1, "Electronics");
        product.setCategory(category);
        assertEquals(category, product.getCategory());
    }

    @Test
    void testManufacturer() {
        product.setManufacturer("Manufacturer");
        assertEquals("Manufacturer", product.getManufacturer());
    }

    @Test
    void testName() {
        product.setName("Product Name");
        assertEquals("Product Name", product.getName());
    }

    @Test
    void testPrice() {
        product.setPrice(100);
        assertEquals(100, product.getPrice());
    }
}
