package com.inter.desafiodigitounico.dtos;
import com.inter.desafiodigitounico.entities.NumberSequence;
import com.inter.desafiodigitounico.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private int id;
    private String name;
    private String email;
    private List<NumberSequence> listDigitoUnico;

    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.listDigitoUnico = user.getListDigitoUnico();
    }
    public UserDto( String name, String email){
        this.name = name;
        this.email = email;
    }
}
