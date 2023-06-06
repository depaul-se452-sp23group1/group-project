/**
 * Lessons Learnt
 *
 * 1) Generated a spring boot project skeleton with dependencies such as Lombok, gradle, log4j, etc
 * 2) Gained experience on resolving merge conflicts.
 * 3) Learned to extend JPA repository and implement CRUD operations
 * 4) Learnt about logging functionality and its various options.
 * 5) Learnt how to setup mariadb and add add corresponding dependency.
 * 6) Learned to create primary key, foreign key, and specify mappings such as one to one, one to many, etc
 * 7) Learned to create controllers and implement GetMapping, PostMApping, etc
 * 8) Created Service classes for all functionalities.
 * 9) Learned to create Junit test cases for lombok functions and CRUD operations.
 * 10) Learned to implement Swagger docs and check the output on localhost
 * 11) Setup Dockerfile and its corresponding compose files with secondary database
 * 12) Learned to setup CI/CD using GIT Actions and Docker hub
 * 13) Learnt and implemented port binding concept
 * 14) Learned Security concepts like authentication, authorization and how to implement them in our project.
 * 15) Learned to setup UI layer and integrate with the existing persistence layer
 * 16) Tested the html pages by hitting the localhost
 *
 * This module contains the controllers, service, repositories and entities for Transactions & Shipping
 * <p>
 * This module has controller mapping & service layer functions for the Transactions class such as :
 * Add Transaction, Update Transaction, Delete Transaction, Get Transaction by ID, Get all Transactions
 * This module also has controller mapping & service layer functions for the following Shipping methods:
 *  Add Shipping, Update Shiiping, Get Shiiping by ID, Get all Shipping
 * </p>
 *<li>
 *     Transactions has one to one relationship with Shipping
 *     Orders has one to one relationship with Transactions
 *     Have implemented Logging with Log4j2
 *</li>
 * <p>
 * Tables Created:  </p>
 * <li>
 *     Transactions
 *     Shipping
 * </li>
 *
 *<p>
 *     Features that were not covered during the lecture
 *  1)Attributes with different annotations were created for different constraints such as non-null, unique, column etc.,
 *  2)Implemented relation between two different tables using foreign key concept (@JoinColumn, @OneToOne annotation).
 *      Transactions has one to one relationship with Shipping
 *      Orders has one to one relationship with Transactions
 *  3)Implemented customized services using different annotations like 'IgnoreJson' etc.,
 *  4)Added api responses for swagger documentation.
 *  5) Multiple database configurations mariadb and postgres.
 *  6) created web controllers along with the dynamic ui pages.
 *</p>
 * @since 1.0
 * @author Bramhashree Manoharan
 * @version 1.1
 *
 * @author bramhashreerm
 */

@NonNullApi
@NonNullFields
package edu.depaul.cdm.se452.transaction;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;