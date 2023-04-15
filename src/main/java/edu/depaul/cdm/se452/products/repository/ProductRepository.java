package edu.depaul.cdm.se452.products.repository;

import edu.depaul.cdm.se452.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(long categoryId);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    Product findByName(String name);

    void deleteById(long id);
}
