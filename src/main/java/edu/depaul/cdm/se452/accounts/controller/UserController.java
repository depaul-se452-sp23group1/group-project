package edu.depaul.cdm.se452.accounts.controller;

import edu.depaul.cdm.se452.accounts.model.User;
import edu.depaul.cdm.se452.accounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public User addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @DeleteMapping("/id/{id}")
    public User deleteUser(@PathVariable long id) {
        return userService.deleteUserById(id);
    }
}
