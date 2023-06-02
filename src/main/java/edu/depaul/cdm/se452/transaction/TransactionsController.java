package edu.depaul.cdm.se452.transaction;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Documented services
 */

@RestController
@RequestMapping("/transactions")
@Log4j2
public class TransactionsController {
    @Autowired
    TransactionService transactionService;

    @GetMapping(value="/id/{id}", produces = "application/json")
    @Operation(summary = "Get transaction details by transaction Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction record found"),
    })
    public Transactions getTransaction(@PathVariable long id) {
        return transactionService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Get all transactions ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " All transaction records found ")
    })
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactions = transactionService.findAll();
        return transactions;
    }

    //add functions for below and above transaction amount
    @PostMapping("/add")
    @Operation(summary = "Adds a new transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "transaction record created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid URL")
    })
    public ResponseEntity<Transactions> addTransaction(@RequestBody Transactions newTransaction) {
        Transactions transaction =  transactionService.addTransaction(newTransaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update Transaction details ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully updated transaction details"),
            @ApiResponse(responseCode = "500",description = "Transaction details record not found")
    })
    public Transactions updateTransaction(@RequestBody Transactions transaction) {
        return  transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Transaction record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Transaction record deleted!!"),
            @ApiResponse(responseCode = "400",description = "No transaction record found")
    })
    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") long id) {
        Transactions presentTransaction = transactionService.findById(id);
        if (presentTransaction != null) {
            transactionService.deleteTransaction(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

