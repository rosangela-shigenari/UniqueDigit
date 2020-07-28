package com.inter.desafiodigitounico.service;

import com.inter.desafiodigitounico.dtos.UserDto;
import com.inter.desafiodigitounico.entities.Result;
import com.inter.desafiodigitounico.entities.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    public User createUser(UserDto createUser){
        User user = new User();

        return user;
    }
}
