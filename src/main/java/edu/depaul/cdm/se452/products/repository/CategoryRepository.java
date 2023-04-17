package edu.depaul.cdm.se452.products.repository;

import edu.depaul.cdm.se452.products.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    List<Category> findByProductsPriceBetween(double minPrice, double maxPrice);

    void deleteById(long id);
}
