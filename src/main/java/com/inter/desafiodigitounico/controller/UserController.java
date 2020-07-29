package com.inter.desafiodigitounico.controller;

import com.inter.desafiodigitounico.dtos.UserDto;
import com.inter.desafiodigitounico.entities.User;
import com.inter.desafiodigitounico.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create-user")
    public User createUser (@RequestBody UserDto newUser){
        return userService.createUser(newUser);
    }

    @PutMapping("/update-user/{id}")
    public User updateUser (@PathVariable int id, @RequestBody UserDto newUser){
        return userService.updateUser(id, newUser);
    }

    @DeleteMapping("delete-user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @GetMapping("/search-user/{id}")
    public User searchUserById(@PathVariable int id, @RequestBody UserDto user){
        return userService.updateUser(id, user);
    }

    @PostMapping("/encrypt/{id}")
    public User encryptUserInfo(@PathVariable int id, @RequestBody UserDto user ) throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        return userService.encryptUser(id, user);
    }

    @PostMapping("/decrypt/{id}")
    public User decryptUserInfo(@PathVariable int id, @RequestBody UserDto user ) throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        return userService.decryptUser(id, user);
    }
}
