package edu.depaul.cdm.se452.transaction.controller;

import edu.depaul.cdm.se452.transaction.model.Transactions;
import edu.depaul.cdm.se452.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value="/{id}", produces = "application/json")
    public Transactions getTransaction(@PathVariable long id) {
        return transactionService.findById(id);
    }

    @GetMapping(value="/date/{date}", produces = "application/json")
    public List<Transactions> getTransactionbyDate(@PathVariable Date date) {
        List<Transactions> transactions = transactionService.findByDate(date);
        return transactions;
    }

    @GetMapping("/")
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactions = transactionService.findAll();
        return transactions;
    }

    //add functions for below and above transaction amount
    @PostMapping
    public Transactions addTransaction(@RequestBody Transactions newTransaction) {
        return transactionService.addTransaction(newTransaction);
    }


}
