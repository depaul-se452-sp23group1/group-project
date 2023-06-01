package edu.depaul.cdm.se452.transaction;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
//checking CI?CD setup
@Service
@Log4j2
public class TransactionService {

    private TransactionsRepository transactionsRepository;
    @Autowired
    public TransactionService(TransactionsRepository transactionsRepository) {

        this.transactionsRepository = transactionsRepository;
    }
    public Transactions findById(long id) {
        log.info("Looking up transaction by id: {} ", id);
        Transactions transactions = transactionsRepository.findById(id);
        return transactions;
    }

    public Transactions addTransaction(Transactions transaction) {
        log.info("Adding a new transaction: {}",transaction);
        log.traceEntry("enter save", transaction);
        transactionsRepository.save(transaction);
        log.traceExit("exit save", transaction);
        return transaction;
    }

     /**public List<Transactions> findByDate(Date tr_date) {
          log.info("Looking up transaction by date: {} ", tr_date.toString());
          log.traceEntry("Enter list");
          List<Transactions> transactions = transactionsRepository.findByDate(tr_date);
          log.traceExit("Exit list", transactions);
          return transactions;
    }**/
    public List<Transactions> findAll(){
        log.info("Retrieving all the transactions {} ");
        log.traceEntry("Enter list");
        List<Transactions> transactions = transactionsRepository.findAll();
        log.traceExit("Exit list", transactions);
        return transactions;
    }

    public Transactions updateTransaction(Transactions transaction) {
        log.info("Updating a Transaction:{}",transaction);
        log.traceEntry("enter save", transaction);
        transactionsRepository.save(transaction);
        log.traceExit("exit save", transaction);
        return transaction;
    }

    public void deleteTransaction(long id) {
        log.traceEntry("Enter delete", id);
        transactionsRepository.deleteById(id);
        log.traceExit("Exit delete");

    }
}
