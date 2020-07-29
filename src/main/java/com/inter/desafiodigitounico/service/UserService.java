package com.inter.desafiodigitounico.service;

import com.inter.desafiodigitounico.dtos.UserDto;
import com.inter.desafiodigitounico.entities.User;
import com.inter.desafiodigitounico.exceptions.UserNotFoundException;
import com.inter.desafiodigitounico.repositories.UserRepository;
import com.inter.desafiodigitounico.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(UserDto createUser){
        User user = new User();

        user.setName(createUser.getName());
        user.setEmail(createUser.getEmail());

        return userRepository.save(user);
    }

    public User updateUser(int id, UserDto newUser){
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u->u.setName(newUser.getName()));
        user.ifPresent(u -> u.setEmail(newUser.getEmail()));
        return userRepository.save(user.orElseThrow(() -> new UserNotFoundException("Usuário com ID " + id + " não foi encontrado!")));
    }

    public void deleteUser (int id){
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.orElseThrow(() -> new UserNotFoundException("Usuário com ID \" + id + \" não foi encontrado!")));
    }

    public User searchUserById(int id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("Usuário com ID \" + id + \" não foi encontrado!"));
    }

    public User encryptUser(int id, UserDto userDto) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u->u.setName(Arrays.toString(EncryptionUtils.encryptString(userDto.getName().getBytes()))));
        user.ifPresent(u -> u.setEmail(Arrays.toString(EncryptionUtils.encryptString(userDto.getEmail().getBytes()))));

        return user.orElseThrow(() -> new UserNotFoundException("Usuário com ID \" + id + \" não foi encontrado!"));
    }

    public User decryptUser(int id, UserDto userDto){
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u->u.setName(Arrays.toString(EncryptionUtils.decryptString(userDto.getName().getBytes()))));
        user.ifPresent(u -> u.setEmail(Arrays.toString(EncryptionUtils.decryptString(userDto.getEmail().getBytes()))));

        return user.orElseThrow(() -> new UserNotFoundException("Usuário com ID \" + id + \" não foi encontrado!"));
    }




}
