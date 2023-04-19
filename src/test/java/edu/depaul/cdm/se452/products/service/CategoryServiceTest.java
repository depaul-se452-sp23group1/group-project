package edu.depaul.cdm.se452.products.service;

import edu.depaul.cdm.se452.products.model.Category;
import edu.depaul.cdm.se452.products.repository.CategoryRepository;
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
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Category category1;
    private Category category2;

    @BeforeEach
    void setUp() {
        category1 = new Category(1, "Electronics");
        category2 = new Category(2, "Books");
    }

    @Test
    void testGetAllCategories() {
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));

        List<Category> result = categoryService.getAllCategories();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Electronics", result.get(0).getName());
        assertEquals("Books", result.get(1).getName());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testGetCategoryById() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category1));

        Category result = categoryService.getCategoryById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Electronics", result.getName());
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCategoryByName() {
        when(categoryRepository.findByName("Electronics")).thenReturn(category1);

        Category result = categoryService.getCategoryByName("Electronics");

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Electronics", result.getName());
        verify(categoryRepository, times(1)).findByName("Electronics");
    }

    @Test
    void testSaveCategory() {
        when(categoryRepository.save(category1)).thenReturn(category1);

        Category result = categoryService.saveCategory(category1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Electronics", result.getName());
        verify(categoryRepository, times(1)).save(category1);
    }

    @Test
    void testDeleteCategory() {
        doNothing().when(categoryRepository).deleteById(1L);

        categoryService.deleteCategory(1);

        verify(categoryRepository, times(1)).deleteById(1L);
    }
}
