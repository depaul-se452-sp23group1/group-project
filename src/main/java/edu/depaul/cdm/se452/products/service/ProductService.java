package edu.depaul.cdm.se452.products.service;

import edu.depaul.cdm.se452.products.model.Category;
import edu.depaul.cdm.se452.products.model.Product;
import edu.depaul.cdm.se452.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductsByCategoryId(long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
