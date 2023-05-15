package edu.depaul.cdm.se452.transaction;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Transactions getTransaction(@PathVariable long id) {
       return transactionService.findById(id);
    }

    @GetMapping(value="/date/{date}", produces = "application/json")
    public List<Transactions> getTransactionbyDate(@PathVariable Date trDate) {
        List<Transactions> transactions = transactionService.findByDate(trDate);
        return transactions;
    }

    @GetMapping
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactions = transactionService.findAll();
        return transactions;
    }

    //add functions for below and above transaction amount
    @PostMapping
    public ResponseEntity<Transactions> addTransaction(@RequestBody Transactions newTransaction) {
        Transactions transaction =  transactionService.addTransaction(newTransaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }
    @PutMapping
    public Transactions updateTransaction(@RequestBody Transactions transaction) {
        return  transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/{id}")
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
