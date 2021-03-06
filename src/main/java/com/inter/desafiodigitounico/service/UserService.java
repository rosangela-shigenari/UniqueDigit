package com.inter.desafiodigitounico.service;

import com.inter.desafiodigitounico.dtos.NumberDto;
import com.inter.desafiodigitounico.dtos.UserDto;
import com.inter.desafiodigitounico.entities.NumberSequence;
import com.inter.desafiodigitounico.entities.User;
import com.inter.desafiodigitounico.exceptions.UserNotFoundException;
import com.inter.desafiodigitounico.repositories.UserRepository;
import com.inter.desafiodigitounico.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        return userRepository.save(user.orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!")));
    }

    public void deleteUser (int id){
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!")));
    }

    public User  searchUserById(int id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!"));
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

    public List<NumberDto> getAllNumberSequenceById(int id){
        List<NumberDto> numbersById = new ArrayList<>();
        Optional<User> user = userRepository.findById(id);
        for(NumberDto numberDto : CacheMemoryService.getCache()){
            if(numberDto.getUserId() == id){
                user.ifPresent(u->u.addList(new NumberSequence(numberDto)));
                numbersById.add(numberDto);
            }
        }
        userRepository.save(user.orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!")));

        return numbersById;
    }


}
