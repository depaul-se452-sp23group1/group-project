package edu.depaul.cdm.se452.transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransactionsRepository extends CrudRepository<Transactions, Long> {

    Transactions findById(long id);

  //  List<Transactions> findByDate(Date date);

    List<Transactions> findAll();

    void deleteById(long id);

  //  List<Transactions> findByDate(Date date);
//testing
}
