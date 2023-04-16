package edu.depaul.cdm.se452.accounts.controller;

import edu.depaul.cdm.se452.accounts.model.User;
import edu.depaul.cdm.se452.accounts.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/email/{email}", produces = "application/json")
    public User getUser(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping(value = "/id/{id}", produces = "application/json")
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

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        User us1 = new User();
        us1 = userService.findById(id);
        if (us1 == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<User>( HttpStatus.OK);
        }
}
