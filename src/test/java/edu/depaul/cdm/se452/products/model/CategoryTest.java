package edu.depaul.cdm.se452.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void testNoArgsConstructor() {
        assertNotNull(category);
    }

    @Test
    void testAllArgsConstructor() {
        Category newCategory = new Category(1, "Electronics");
        assertNotNull(newCategory);
        assertEquals(1, newCategory.getId());
        assertEquals("Electronics", newCategory.getName());
    }

    @Test
    void testConstructorWithName() {
        Category newCategory = new Category("Electronics");
        assertNotNull(newCategory);
        assertEquals("Electronics", newCategory.getName());
    }

    @Test
    void testId() {
        category.setId(1);
        assertEquals(1, category.getId());
    }

    @Test
    void testName() {
        category.setName("Electronics");
        assertEquals("Electronics", category.getName());
    }

    @Test
    void testProducts() {
        List<Category.Product> products = new ArrayList<>();
        products.add(new Category.Product(1, "Manufacturer", null, "Product 1", 100));
        products.add(new Category.Product(2, "Manufacturer", null, "Product 2", 200));

        category.setProducts(products);

        assertNotNull(category.getProducts());
        assertEquals(2, category.getProducts().size());
    }
}
