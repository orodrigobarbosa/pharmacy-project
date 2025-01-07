package com.pharmacy_project.user.controller;

import com.pharmacy_project.user.domain.User;
import com.pharmacy_project.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/newuser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/userbyid/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        User updatedUser = userService.updateUser(user, id);
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
