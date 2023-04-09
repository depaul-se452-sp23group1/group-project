package edu.depaul.cdm.se452.accounts.controller;

import edu.depaul.cdm.se452.accounts.model.User;
import edu.depaul.cdm.se452.accounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/email/{email}", produces = "application/json")
    public User getUser(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping(value="/id/{id}", produces = "application/json")
    public User getUser(@PathVariable long id) {
        return userService.findById(id);
    }
}
