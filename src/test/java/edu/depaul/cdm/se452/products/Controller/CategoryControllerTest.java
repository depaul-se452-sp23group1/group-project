package edu.depaul.cdm.se452.products.Controller;

import edu.depaul.cdm.se452.products.model.Category;
import edu.depaul.cdm.se452.products.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryControllerTest {

    private CategoryService categoryService;
    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
        categoryService = mock(CategoryService.class);
        categoryController = new CategoryController();
        categoryController.categoryService = categoryService;
    }

    @Test
    void getAllCategories() {
        Category category1 = new Category(1L, "Electronics");
        Category category2 = new Category(2L, "Books");
        List<Category> categories = Arrays.asList(category1, category2);

        when(categoryService.getAllCategories()).thenReturn(categories);

        List<Category> result = categoryController.getAllCategories();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(categories, result);
        verify(categoryService, times(1)).getAllCategories();
    }

    @Test
    void getCategoryById() {
        Category category = new Category(1L, "Electronics");

        when(categoryService.getCategoryById(1L)).thenReturn(category);

        Category result = categoryController.getCategoryById(1L);

        assertNotNull(result);
        assertEquals(category, result);
        verify(categoryService, times(1)).getCategoryById(1L);
    }

    @Test
    void getCategoryByName() {
        Category category = new Category(1L, "Electronics");

        when(categoryService.getCategoryByName("Electronics")).thenReturn(category);

        Category result = categoryController.getCategoryByName("Electronics");

        assertNotNull(result);
        assertEquals(category, result);
        verify(categoryService, times(1)).getCategoryByName("Electronics");
    }

    @Test
    void createCategory() {
        Category category = new Category("Electronics");

        when(categoryService.saveCategory(any(Category.class))).thenReturn(category);

        Category result = categoryController.createCategory(category);

        assertNotNull(result);
        assertEquals(category, result);
        verify(categoryService, times(1)).saveCategory(any(Category.class));
    }

    @Test
    void updateCategory() {
        Category updatedCategory = new Category("Updated Electronics");
        updatedCategory.setId(1L);

        when(categoryService.saveCategory(any(Category.class))).thenReturn(updatedCategory);

        Category result = categoryController.updateCategory(1L, updatedCategory);

        assertNotNull(result);
        assertEquals("Updated Electronics", result.getName());
        verify(categoryService, times(1)).saveCategory(any(Category.class));
    }

    @Test
    void deleteCategory() {
        doNothing().when(categoryService).deleteCategory(1L);
        categoryController.deleteCategory(1L);
        verify(categoryService, times(1)).deleteCategory(1L);
    }

}
