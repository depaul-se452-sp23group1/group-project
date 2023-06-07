/**
 * The modules contain the Controller, service, repository and entities for User accounts.
 * <p>
 *  This module has controller mapping and service layer functions for the Customer class such as:
 *  AddCustomer, DeleteCustomer, UpdateCustomer, getCustomerByID, getCustomerByEmail, FindCustomerByID, Find CustomerByEmail,
 *  The Repository module has the inbuilt Jpa repository methods.
 *  1) Generated a spring boot project skeleton with dependencies such as Lombok, gradle, log4j, etc
 *  2) Gained experience on resolving merge conflicts.
 *  3) Learned to extend JPA repository and implement CRUD operations
 *  4) Learnt about logging functionality and its various options.
 *  5) Learnt how to setup mariadb and add add corresponding dependency.
 *  6) Learned to create primary key, foreign key, and specify mappings such as one to one, one to many, etc
 *  7) Learned to create controllers and implement GetMapping, PostMApping, etc
 *  8) Created Service classes for all functionalities.
 *  9) Learned to create Junit test cases for lombok functions and CRUD operations.
 *  10) Learned to implement Swagger docs and check the output on localhost
 *  11) Learned Security concepts like authentication, authorization and how to implement them in our project.
 *  12) Learned to setup UI layer and integrate with the existing persistence layer
 *  13 Tested the html pages by hitting the localhost
 * </p>
 * <li>
 *     Customers can be added to the database in order to enter the system
 *     I had implemented Logging with Log4j2
 *     Tested with PostMan App
 *     Also Implemented Junit tests in Test folder
 * </li>
 * @since 1.0
 * @author karthikrajachandrasekaran
 * @version 1.1
 *
 */
@NonNullApi
@NonNullFields
package edu.depaul.cdm.se452.accounts;

import io.micrometer.common.lang.NonNullApi;
import io.micrometer.common.lang.NonNullFields;