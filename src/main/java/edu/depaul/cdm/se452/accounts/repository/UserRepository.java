package edu.depaul.cdm.se452.accounts.repository;

import edu.depaul.cdm.se452.accounts.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
    User findById(long id);

    User deleteUserById(long id);
}
