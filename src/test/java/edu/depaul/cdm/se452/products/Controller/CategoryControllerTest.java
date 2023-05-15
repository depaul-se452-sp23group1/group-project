package edu.depaul.cdm.se452.products.Controller;

import static org.junit.jupiter.api.Assertions.*;


import edu.depaul.cdm.se452.products.model.Category;
import edu.depaul.cdm.se452.products.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
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
    void testGetAllCategories() {
        Category category1 = new Category(1, "Electronics");
        Category category2 = new Category(2, "Books");
        List<Category> categories = Arrays.asList(category1, category2);

        when(categoryService.getAllCategories()).thenReturn(categories);

        List<Category> result = categoryController.getAllCategories();

        assertNotNull(result);
        assertEquals(categories, result);
        verify(categoryService, times(1)).getAllCategories();
    }

    @Test
    void testGetCategoryByIdFound() {
        Category category = new Category(1, "Electronics");

        when(categoryService.getCategoryById(1)).thenReturn(category);

        ResponseEntity<Category> result = categoryController.getCategoryById(1);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(category, result.getBody());
        verify(categoryService, times(1)).getCategoryById(1);
    }

    @Test
    void testGetCategoryByIdNotFound() {
        when(categoryService.getCategoryById(1)).thenReturn(null);

        ResponseEntity<Category> result = categoryController.getCategoryById(1);

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
        verify(categoryService, times(1)).getCategoryById(1);
    }

    @Test
    void testGetCategoryByNameFound() {
        Category category = new Category(1, "Electronics");

        when(categoryService.getCategoryByName("Electronics")).thenReturn(category);

        ResponseEntity<Category> result = categoryController.getCategoryByName("Electronics");

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(category, result.getBody());
        verify(categoryService, times(1)).getCategoryByName("Electronics");
    }

    @Test
    void testGetCategoryByNameNotFound() {
        when(categoryService.getCategoryByName("Electronics")).thenReturn(null);

        ResponseEntity<Category> result = categoryController.getCategoryByName("Electronics");

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
        verify(categoryService, times(1)).getCategoryByName("Electronics");
    }


    @Test
    void testUpdateCategoryNotFound() {
        when(categoryService.getCategoryById(1)).thenReturn(null);

        ResponseEntity<Category> result = categoryController.updateCategory(1, new Category("Updated Electronics"));

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
        verify(categoryService, times(1)).getCategoryById(1);
    }

    @Test
    void testDeleteCategoryFound() {
        Category category = new Category(1, "Electronics");

        when(categoryService.getCategoryById(1)).thenReturn(category);

        ResponseEntity<Void> result = categoryController.deleteCategory(1);

        assertNotNull(result);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(categoryService, times(1)).getCategoryById(1);
        verify(categoryService, times(1)).deleteCategory(1);
    }

    @Test
    void testDeleteCategoryNotFound() {
        when(categoryService.getCategoryById(1)).thenReturn(null);

        ResponseEntity<Void> result = categoryController.deleteCategory(1);

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        verify(categoryService, times(1)).getCategoryById(1);
    }


}
