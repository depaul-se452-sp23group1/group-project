package edu.depaul.cdm.se452.products.Controller;

import edu.depaul.cdm.se452.products.model.Product;
import edu.depaul.cdm.se452.products.service.CategoryService;
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
    private CategoryService categoryService;
    private ProductController productController;

    @BeforeEach
    void setUp() {
        productService = mock(ProductService.class);
        categoryService = mock(CategoryService.class);
        productController = new ProductController();

        productController.productService = productService;
        productController.categoryService = categoryService;
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
    void testGetProductByIdFound() {
        Product product = new Product(1, "Product 1", 100.0, "Description 1");

        when(productService.getProductById(1)).thenReturn(product);

        ResponseEntity<Product> result = productController.getProductById(1);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(product, result.getBody());
        verify(productService, times(1)).getProductById(1);
    }

    @Test
    void testGetProductByIdNotFound() {
        when(productService.getProductById(1)).thenReturn(null);

        ResponseEntity<Product> result = productController.getProductById(1);

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
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
    void testGetProductByNameFound() {
        Product product = new Product(1, "Product 1", 100.0, "Description 1");

        when(productService.getProductByName("Product 1")).thenReturn(product);

        ResponseEntity<Product> result = productController.getProductByName("Product 1");

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(product, result.getBody());
        verify(productService, times(1)).getProductByName("Product 1");
    }

    @Test
    void testGetProductByNameNotFound() {
        when(productService.getProductByName("Product 1")).thenReturn(null);

        ResponseEntity<Product> result = productController.getProductByName("Product 1");

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
        verify(productService, times(1)).getProductByName("Product 1");
    }


    @Test
    void testUpdateProductNotFound() {
        Product updatedProduct = new Product("Updated Product1", 120.0, "Updated Description 1");
        when(productService.getProductById(1)).thenReturn(null);

        ResponseEntity<Product> result = productController.updateProduct(1, updatedProduct);

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
        verify(productService, times(1)).getProductById(1);
        verify(productService, never()).saveProduct(any(Product.class));
    }

    @Test
    void testDeleteProductFound() {
        Product existingProduct = new Product(1, "Product 1", 100.0, "Description 1");

        when(productService.getProductById(1)).thenReturn(existingProduct);

        ResponseEntity<Void> result = productController.deleteProduct(1);

        assertNotNull(result);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(productService, times(1)).getProductById(1);
        verify(productService, times(1)).deleteProduct(1);
    }

    @Test
    void testDeleteProductNotFound() {
        when(productService.getProductById(1)).thenReturn(null);

        ResponseEntity<Void> result = productController.deleteProduct(1);

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        verify(productService, times(1)).getProductById(1);
        verify(productService, never()).deleteProduct(1);
    }
}

