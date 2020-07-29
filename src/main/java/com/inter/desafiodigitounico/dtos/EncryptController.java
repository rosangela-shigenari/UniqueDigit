package com.inter.desafiodigitounico.dtos;

import com.inter.desafiodigitounico.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crypt")
public class EncryptController {
    @Autowired
    UserService userService;


}
