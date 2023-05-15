/**
 * The modules contain the Controller, service, repository and entities for User accounts.
 * <p>
 *  This module has controller mapping and service layer functions for the Customer class such as:
 *  AddCustomer, DeleteCustomer, UpdateCustomer, getCustomerByID, getCustomerByEmail, FindCustomerByID, Find CustomerByEmail,
 *  The Repository module has the inbuilt Jpa repository methods.
 * </p>
 * <li>
 *     Customers can be added to the database in order enter the system
 *     I had implemented Logging with Log4j2
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