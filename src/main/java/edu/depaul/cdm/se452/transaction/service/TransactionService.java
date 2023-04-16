package edu.depaul.cdm.se452.transaction.service;

import edu.depaul.cdm.se452.accounts.model.Customer;
import edu.depaul.cdm.se452.transaction.model.Transactions;
import edu.depaul.cdm.se452.transaction.repository.TransactionsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        return transactionsRepository.save(transaction);
    }

  //  public List<Transactions> findByDate(Date date) {
    //    log.info("Looking up transaction by date: {} ", date);
      //  List<Transactions> transactions = transactionsRepository.findByDate(date);
        //return transactions;
    //}
    public List<Transactions> findAll(){
        log.info("Retrieving all the transactions {} ");
        List<Transactions> transactions = transactionsRepository.findAll();
        return transactions;
    }

    public Transactions updateTransaction(Transactions transaction) {
        log.info("Updating a Transaction:{}",transaction);
        return transactionsRepository.save(transaction);
    }

}
