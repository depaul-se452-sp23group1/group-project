package edu.depaul.cdm.se452.products.Controller;

import edu.depaul.cdm.se452.products.model.Product;
import edu.depaul.cdm.se452.products.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerTest {
    private ProductService productService;
    private ProductController productController;

    @BeforeEach
    void setUp() {
        productService = mock(ProductService.class);
        productController = new ProductController();

        productController.productService = productService;
    }


    @Test
    void testGetAllProducts() {
        Product product1 = new Product(1, "Product 1", 100.0, "Description 1");
        Product product2 = new Product(2, "Product 2", 150.0, "Description 2");
        List<Product> products = Arrays.asList(product1, product2);

        when(productService.getAllProducts()).thenReturn(products);

        List<Product> result = productController.getAllProducts();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(products, result);
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testGetProductById() {
        Product product = new Product(1, "Product 1", 100.0, "Description 1");

        when(productService.getProductById(1)).thenReturn(product);

        Product result = productController.getProductById(1);

        assertNotNull(result);
        assertEquals(product, result);
        verify(productService, times(1)).getProductById(1);
    }

    @Test
    void testGetProductsByCategoryId() {
        Product product1 = new Product(1, "Product 1", 100.0, "Description 1");
        Product product2 = new Product(2, "Product 2", 150.0, "Description 2");
        List<Product> products = Arrays.asList(product1, product2);

        when(productService.getProductsByCategoryId(1)).thenReturn(products);

        List<Product> result = productController.getProductsByCategoryId(1);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(products, result);
        verify(productService, times(1)).getProductsByCategoryId(1);
    }

    @Test
    void testGetProductsByPriceRange() {
        Product product1 = new Product(1, "Product 1", 100.0, "Description 1");
        Product product2 = new Product(2, "Product 2", 150.0, "Description 2");
        List<Product> products = Arrays.asList(product1, product2);

        when(productService.getProductsByPriceRange(100.0, 200.0)).thenReturn(products);

        List<Product> result = productController.getProductsByPriceRange(100.0, 200.0);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(products, result);
        verify(productService, times(1)).getProductsByPriceRange(100.0, 200.0);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product(1, "Product 1", 100.0, "Description 1");

        when(productService.saveProduct(product)).thenReturn(product);

        Product result = productController.createProduct(product);

        assertNotNull(result);
        assertEquals(product, result);
        verify(productService, times(1)).saveProduct(product);
    }

    @Test
    void testUpdateProduct() {
        Product existingProduct = new Product(1, "Product 1", 100.0, "Description 1");
        Product updatedProduct = new Product(1, "Updated Product1", 120.0, "Updated Description 1");

        when(productService.getProductById(1)).thenReturn(existingProduct);
        when(productService.saveProduct(updatedProduct)).thenReturn(updatedProduct);

        ResponseEntity<Product> result = productController.updateProduct(1, updatedProduct);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(updatedProduct, result.getBody());
        verify(productService, times(1)).getProductById(1);
        verify(productService, times(1)).saveProduct(updatedProduct);
    }


    @Test
    void testDeleteProduct() {
        Product existingProduct = new Product(1, "Product 1", 100.0, "Description 1");

        when(productService.getProductById(1)).thenReturn(existingProduct);

        ResponseEntity<Void> result = productController.deleteProduct(1);

        assertNotNull(result);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(productService, times(1)).getProductById(1);
        verify(productService, times(1)).deleteProduct(1);
    }

}
