package com.inter.desafiodigitounico.entities;

import com.inter.desafiodigitounico.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    @OneToMany(targetEntity=User.class, fetch= FetchType.EAGER)
    private List<NumberSequence> listDigitoUnico;

    public User(UserDto userDto){
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.listDigitoUnico = userDto.getListDigitoUnico();
    }

    public void addList(NumberSequence numberSequence){
        listDigitoUnico.add(numberSequence);
    }



}
