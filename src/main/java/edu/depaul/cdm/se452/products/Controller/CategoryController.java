package edu.depaul.cdm.se452.products.Controller;

import edu.depaul.cdm.se452.products.model.Category;
import edu.depaul.cdm.se452.products.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Get all categories ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " All categories found ")
    })
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get category by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    public Category getCategoryById(@PathVariable("id") long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Get category by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    public Category getCategoryByName(@PathVariable("name") String name) {
        return categoryService.getCategoryByName(name);
    }

    @PostMapping
    @Operation(summary = "Create a new category ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid URL")
    })
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update category ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully updated category"),
            @ApiResponse(responseCode = "404",description = "Category not found")
    })
    public Category updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
        category.setId(id);
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete category ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Category deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    public void deleteCategory(@PathVariable("id") long id) {
        categoryService.deleteCategory(id);
    }
}
