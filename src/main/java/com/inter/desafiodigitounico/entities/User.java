package com.inter.desafiodigitounico.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Getter
    private String name;
    private String email;

}
