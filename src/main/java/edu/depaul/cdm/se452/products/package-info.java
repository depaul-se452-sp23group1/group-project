/**
 * This module contains the controllers, models, and repositories for Products & Categories.
 *
 * <p>
 * This module provides the following features for managing products and categories:
 * - Category management: Add Category, Update Category, Delete Category, Get Category by ID, Get all Categories
 * - Product management: Add Product, Update Product, Delete Product, Get Product by ID, Get all Products
 * </p>
 *
 * <p>
 * The module includes the following classes:
 * - CategoryController: Handles HTTP requests related to category management.
 * - ProductController: Handles HTTP requests related to product management.
 * - Category: Represents a category entity with properties like ID and name.
 * - Product: Represents a product entity with properties like ID, name, price, etc.
 * - CategoryRepository: Provides CRUD operations for the Category entity.
 * - ProductRepository: Provides CRUD operations for the Product entity.
 * </p>
 *
 * <p>
 * The module uses a one-to-many relationship between Category and Product entities.
 * Each Category can have multiple Products associated with it.
 * </p>
 *
 * @since 1.0
 * @author [Chandrashekar Goud Kalali]
 * @version 1.1
 */
@NonNullApi
@NonNullFields
package edu.depaul.cdm.se452.products;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
