/**
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
 * @since 1.0
 * @author Bramhashree Manoharan
 * @version 1.1
 */

@NonNullApi
@NonNullFields
package edu.depaul.cdm.se452.transaction;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;