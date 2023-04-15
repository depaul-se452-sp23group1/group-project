package edu.depaul.cdm.se452.accounts.service;

import edu.depaul.cdm.se452.accounts.model.Customer;
import edu.depaul.cdm.se452.accounts.model.User;
import edu.depaul.cdm.se452.accounts.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        log.info("Looking up user by email: {} ",email);
        User user = userRepository.findByEmail(email);
        return user;
    }

    public User findById(long id) {
        log.info("Looking up user by id: {} ", id);
        User user = userRepository.findById(id);
        return user;
    }

    public User addUser(User user) {
        log.info("Adding a new user: {}",user);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        if (userRepository.findById(user.getId())!= null){
            log.info("Updating a User:{}",user);
            return userRepository.save(user);
        }
        log.info("Adding a new user since none matches:{}",user);
        return addUser(user);
    }
    public User deleteUserById(long id) {
        log.info("Deleting the User info:{}",id);
        return userRepository.deleteById(id);
    }
}
