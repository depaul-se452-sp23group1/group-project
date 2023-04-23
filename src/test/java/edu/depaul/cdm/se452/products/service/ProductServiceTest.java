package edu.depaul.cdm.se452.products.service;

import edu.depaul.cdm.se452.products.model.Category;
import edu.depaul.cdm.se452.products.model.Product;
import edu.depaul.cdm.se452.products.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Category category;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        category = new Category(1, "Electronics");
        product1 = new Product(1, category, "Manufacturer1", "Product1", 100);
        product2 = new Product(2, category, "Manufacturer2", "Product2", 200);
    }

    @Test
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product1", result.get(0).getName());
        assertEquals("Product2", result.get(1).getName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));

        Product result = productService.getProductById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Product1", result.getName());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void testGetProductsByCategoryId() {
        when(productRepository.findByCategoryId(1L)).thenReturn(Arrays.asList(product1, product2));

        List<Product> result = productService.getProductsByCategoryId(1);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product1", result.get(0).getName());
        assertEquals("Product2", result.get(1).getName());
        verify(productRepository, times(1)).findByCategoryId(1L);
    }

    @Test
    void testGetProductsByPriceRange() {
        when(productRepository.findByPriceBetween(100.0, 200.0)).thenReturn(Arrays.asList(product1, product2));

        List<Product> result = productService.getProductsByPriceRange(100.0, 200.0);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product1", result.get(0).getName());
        assertEquals("Product2", result.get(1).getName());
        verify(productRepository, times(1)).findByPriceBetween(100.0, 200.0);
    }

    @Test
    void testGetProductByName() {
        when(productRepository.findByName("Product1")).thenReturn(product1);

        Product result = productService.getProductByName("Product1");

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Product1", result.getName());
        verify(productRepository, times(1)).findByName("Product1");
    }

    @Test
    void testSaveProduct() {
        when(productRepository.save(product1)).thenReturn(product1);

        Product result = productService.saveProduct(product1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Product1", result.getName());
        verify(productRepository, times(1)).save(product1);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteProduct(1);

        verify(productRepository, times(1)).deleteById(1L);
    }
}
