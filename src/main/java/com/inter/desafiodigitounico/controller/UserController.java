package com.inter.desafiodigitounico.controller;

import com.inter.desafiodigitounico.dtos.NumberDto;
import com.inter.desafiodigitounico.dtos.UserDto;
import com.inter.desafiodigitounico.entities.User;
import com.inter.desafiodigitounico.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "Insere o dado inserido no corpo.")
    @PostMapping("/create-user")
    public User createUser (@RequestParam("name")String name, @RequestParam("email")String email){
        UserDto newUser = new UserDto(name, email);
        return userService.createUser(newUser);
    }

    @ApiOperation(value = "Atualiza o usuário com o id passado como parâmetro, pelo usuário passado no corpo da requisição.")
    @PutMapping("/update-user/{id}")
    public User updateUser (@PathVariable int id, @RequestBody UserDto newUser){
        return userService.updateUser(id, newUser);
    }

    @ApiOperation(value = "Deleta o usuário com o Id passado como parâmetro.")
    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @ApiOperation(value = "Busca um usuário pelo seu Id.")
    @GetMapping("/search-user/{id}")
    public User searchUserById(@PathVariable int id){
        return userService.searchUserById(id);
    }

    @ApiOperation(value = "Lista todos os dígitos únicos associado ao Id.")
    @GetMapping("/listAll-digitounico/{id}")
    public List<NumberDto> getAllDigitoUnicoById(@PathVariable int id){
        return userService.getAllNumberSequenceById(id);
    }

    @ApiOperation(value = "Criptografa o nome e email do usuário com o Id passado como parâmetro.")
    @PutMapping("/encrypt/{id}")
    public User encryptUserInfo(@PathVariable int id ) {
        UserDto user = new UserDto(userService.searchUserById(id));
        return userService.encryptUser(id, user);
    }

    @ApiOperation(value = "Decriptografa o nome e email do usuário com o Id passado como parâmetro.")
    @PutMapping("/decrypt/{id}")
    public User decryptUserInfo(@PathVariable int id) {
        UserDto user = new UserDto(userService.searchUserById(id));
        return userService.decryptUser(id, user);
    }
}
